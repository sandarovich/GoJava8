package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.category.CategoryDaoFactory;
import com.sandarovich.kickstarter.dao.quote.QuoteDao;
import com.sandarovich.kickstarter.dao.quote.QuoteDaoFactory;
import com.sandarovich.kickstarter.domain.Quote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class KickstarterWeb extends HttpServlet {
    public static final String DAO_MODE = "daoMode";
    private QuoteDao quoteDao;
    private CategoryDao categoryDao;
    private ServletContext context;

    public void init(ServletConfig config) {
        String mode = null;
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            mode = (String) envCtx.lookup(DAO_MODE);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        DaoMode daoMode = DaoMode.fromName(mode);
        quoteDao = new QuoteDaoFactory().getQuotaDao(daoMode);
        categoryDao = new CategoryDaoFactory().getCategoryDao(daoMode);
        context = config.getServletContext();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        Quote quote = quoteDao.getRandomQuota();
        req.setAttribute("quote", "\"" + quote.getQuote() + "\" - " + quote.getAuthor());

        req.setAttribute("title", "Kickstarter");
        RequestDispatcher rd = req.getRequestDispatcher("layouts/index.jsp");
        rd.forward(req, res);
    }

}
