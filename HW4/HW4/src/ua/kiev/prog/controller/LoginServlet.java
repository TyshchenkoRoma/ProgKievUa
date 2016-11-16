package ua.kiev.prog.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet",  urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
    private static String LOGIN = "admin";
    private static String PASS = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("");
        String password = request.getParameter("");

        if (LOGIN.equals(login) && (PASS.equals(password))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
        }
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && session != null) {
            session.removeAttribute("user_login");
        }
        response.sendRedirect("index.jsp");
    }
}

