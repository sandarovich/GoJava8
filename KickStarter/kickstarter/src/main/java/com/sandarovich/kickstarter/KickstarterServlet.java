package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.*;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class KickstarterServlet extends HttpServlet {

    private static final String IDENTIFIER_VIEW = "view";
    private static final String CATEGORY_VIEW = "category";
    private static final String CATEGORIES_VIEW = "categories";
    private static final String PROJECT_VIEW = "project";
    private static final String QUESTION_VIEW = "question";
    private static final String INVEST_VIEW = "invest";
    private static final String QUESTION_ADD_ACTION = "addQuestion";
    private static final String PAYMENT_ADD_ACTION = "addInvestment";
    private static final String WEB_INF_LAYOUTS = "/WEB-INF/layouts";

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AwardDao awardDao;

    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestedAction = request.getParameter("action");
        if (QUESTION_ADD_ACTION.equals(requestedAction)) {
            addQuestion(request, response);
        } else if (PAYMENT_ADD_ACTION.equals(requestedAction)) {
            addInvestment(request, response);
        }
    }

    private void addInvestment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = 0;
        Payment payment = new Payment();
        if (request.getParameter("award") == null || request.getParameter("award").isEmpty()) {
            payment.setAmount(Double.valueOf(request.getParameter("amount")));
        } else {
            payment.setAmount(Double.valueOf(request.getParameter("award")));
        }
        payment.setCardHolder(request.getParameter("cardHolder"));
        payment.setCardNumber(request.getParameter("cardNumber"));
        try {
            projectId = Integer.valueOf(request.getParameter("projectId"));
            projectDao.findProjectById(projectId);
        } catch (NumberFormatException | NoResultException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        projectDao.invest(payment, projectId);
        response.sendRedirect("/kickstarter/kickstarter?view=project&id=" + projectId);
    }

    private void addQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(request.getParameter("projectId"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Question question = new Question();
        question.setText(request.getParameter("question"));
        questionDao.addQuestion(question, projectId);
        response.sendRedirect("/kickstarter/kickstarter?view=project&id=" + projectId);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        String requestView = request.getParameter(IDENTIFIER_VIEW);
        if (requestView == null || request.getQueryString() == null) {
            showMainPage(request, response);
        } else if (CATEGORIES_VIEW.equals(requestView)) {
            showCategoriesPage(request, response);
        } else if (CATEGORY_VIEW.equals(requestView)) {
            showCategoryPage(request, response);
        } else if (PROJECT_VIEW.equals(requestView)) {
            showProjectPage(request, response);
        } else if (QUESTION_VIEW.equals(requestView)) {
            showQuestionPage(request, response);
        } else if (INVEST_VIEW.equals(requestView)) {
            showInvestPage(request, response);
        }
    }

    private void showInvestPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Project project = null;
        try {
            project = projectDao.findProjectById(projectId);
        } catch (NoResultException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        List<Award> awards = awardDao.getAwardsByProject(project);
        request.setAttribute("project", project);
        request.setAttribute("title", "Invest");
        request.setAttribute("awards", awards);
        RequestDispatcher rd = request.getRequestDispatcher(WEB_INF_LAYOUTS + "/invest.jsp");
        rd.forward(request, response);
    }

    private void showQuestionPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Project project = null;
        try {
            project = projectDao.findProjectById(projectId);
        } catch (NoResultException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        request.setAttribute("title", "Question");
        request.setAttribute("project", project);
        RequestDispatcher rd = request.getRequestDispatcher(WEB_INF_LAYOUTS + "/question.jsp");
        rd.forward(request, response);
    }

    private void showProjectPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Project project = null;
        try {
            project = projectDao.findProjectById(projectId);

        } catch (NoResultException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        List<Question> questions;
        questions = questionDao.getQuestions(project);
        Category category = categoryDao.findCategoryByProject(project);
        request.setAttribute("title", project.getName());
        request.setAttribute("project", project);
        request.setAttribute("questions", questions);
        request.setAttribute("category", category);
        RequestDispatcher rd = request.getRequestDispatcher(WEB_INF_LAYOUTS + "/project.jsp");
        rd.forward(request, response);
    }

    private void showCategoryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = 0;
        try {
            categoryId = Integer.valueOf(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Category category = null;
        try {
            category = categoryDao.findCategoryById(categoryId);
        } catch (NoResultException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        request.setAttribute("title", category.getName());
        request.setAttribute("category", category);
        request.setAttribute("projects", projectDao.getProjects(category));
        RequestDispatcher rd = request.getRequestDispatcher(WEB_INF_LAYOUTS + "/category.jsp");
        rd.forward(request, response);
    }

    private void showCategoriesPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Categories");
        List<Category> categories = categoryDao.getCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher rd = request.getRequestDispatcher(WEB_INF_LAYOUTS + "/categories.jsp");
        rd.forward(request, response);
    }

    private void showMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quote quote = quoteDao.getRandomQuota();
        request.setAttribute("quote", "\"" + quote.getQuote() + "\" - " + quote.getAuthor());
        request.setAttribute("title", "Kickstarter");
        RequestDispatcher rd = request.getRequestDispatcher(WEB_INF_LAYOUTS + "/index.jsp");
        rd.forward(request, response);
    }


}
