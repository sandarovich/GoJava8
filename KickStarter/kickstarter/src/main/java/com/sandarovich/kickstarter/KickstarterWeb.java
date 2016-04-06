package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.category.CategoryDaoDbImpl;
import com.sandarovich.kickstarter.dao.quote.QuoteDao;
import com.sandarovich.kickstarter.dao.quote.QuoteDaoDbImpl;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Quote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;


public class KickstarterWeb extends HttpServlet {

    public static final String DAO_MODE = "daoMode";
    public static final String VIEW_PAGE_PARAMETER = "view";
    public static final String CATEGORIES_VIEW = "categories";
    public static final String CATEGORY_VIEW = "category";

    private QuoteDao quoteDao;
    private CategoryDao categoryDao;
    private ServletContext context;
    private DataSource dataSource;

    public void initDataSource() {
        try {
            Class.forName("org.postgresql.Driver");
            InitialContext initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/kickstarter");
        } catch (ClassNotFoundException | NamingException e) {
            throw new RuntimeException(e);
        }

    }

    public void init(ServletConfig config) {
        initDataSource();
        quoteDao = new QuoteDaoDbImpl(dataSource);
        categoryDao = new CategoryDaoDbImpl(dataSource);
        context = config.getServletContext();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
        String requestPage = req.getParameter(VIEW_PAGE_PARAMETER);
        if (requestPage == null || req.getQueryString() == null) {
            showMainPage(req, res);
        } else if (CATEGORIES_VIEW.equals(requestPage)) {
            showCategoriesPage(req, res);
        } else if (CATEGORY_VIEW.equals(requestPage)) {
            showCategoryPage(req, res);
        }

    }

    private void showCategoryPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Category category = categoryDao.findCategoryById(id);
        req.setAttribute("title", category.getName());
        req.setAttribute("category", category);
        req.setAttribute("projects", category.getProjects());
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/layouts/category.jsp");
        rd.forward(req, res);
    }

    private void showCategoriesPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("title", "Categories:");
        List<Category> categories = categoryDao.getCategories();
        req.setAttribute("categories", categories);
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/layouts/categories.jsp");
        rd.forward(req, res);
    }

    private void showMainPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Quote quote = quoteDao.getRandomQuota();
        req.setAttribute("quote", "\"" + quote.getQuote() + "\" - " + quote.getAuthor());
        req.setAttribute("title", "Kickstarter");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/layouts/index.jsp");
        rd.forward(req, res);
    }

//    private String getDaoModeFromEnvironment() {
//        String mode = null;
//        try {
//            Context initCtx = new InitialContext();
//            Context envCtx = (Context) initCtx.lookup("java:comp/env");
//            mode = (String) envCtx.lookup(DAO_MODE);
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        return mode;
//    }

}
