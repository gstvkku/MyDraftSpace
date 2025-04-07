package io.codeforall.bootcamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyLittleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/form.jsp");
        page1Dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String email = req.getParameter("email");
        getServletContext().setAttribute("name", name);
        getServletContext().setAttribute("email", email);
        RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/card.jsp");
        page1Dispatcher.forward(req, resp);
    }
}
