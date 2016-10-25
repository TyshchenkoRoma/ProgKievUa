package ua.kiev.prog.form;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Created by roman on 24.10.16.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");

        if (firstName != "" && lastName != "" && age != "") {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/quest");
            dispatcher.forward(request, response);

//
//            dispatcher = this.getServletContext().getRequestDispatcher("/Form.jsp");
//            dispatcher.forward(request, response);

           // response.sendRedirect();
        } else {
                    PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>\n" + // формируем HTML страницы
                    "<html>\n" +
                    "<head><title>LOGIN</title></head>\n" +
                    "<body >\n" +
                    "<h1>Wrong DATA</h1>\n" +
                    "<p>Pleace input right data</p>\n" +
                    "</body></html>");
        }
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "Form.jsp");
    }
}
