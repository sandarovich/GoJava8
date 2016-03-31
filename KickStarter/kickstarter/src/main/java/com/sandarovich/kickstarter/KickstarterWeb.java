package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.DaoMode;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class KickstarterWeb extends HttpServlet {
    public static final String DAO_MODE = "daoMode";
    private DaoMode daoMode;

    public void init() {
        String mode = null;
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            mode = (String) envCtx.lookup(DAO_MODE);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        this.daoMode = DaoMode.fromName(mode);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        RequestDispatcher rd = req.getRequestDispatcher("layouts/kickstarter.jsp");
        rd.forward(req, res);
    }

}
