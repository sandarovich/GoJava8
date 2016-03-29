package com.sandarovich.kickstarter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KickstarterWeb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("layouts/kickstarter.jsp");
        rd.forward(req, res);
    }

}
