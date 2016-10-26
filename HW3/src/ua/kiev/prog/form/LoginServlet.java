package ua.kiev.prog.form;

import ua.kiev.prog.form.entity.Person;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Created by roman on 24.10.16.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
Person person;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age=0;
        if (!request.getParameter("age").isEmpty()) {
             age =Integer.parseInt(request.getParameter("age"));
        }
        if (!firstName.isEmpty()  && !lastName.isEmpty() ) {
            person = new Person(firstName, lastName, age);
            response.sendRedirect("Form.jsp");
        } else {
                    PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>\n" + // формируем HTML страницы
                    "<html>\n" +
                    "<head><title>LOGIN</title></head>\n" +
                    "<body >\n" +
                    "<h1>Wrong DATA</h1>\n" +
                    "<p>Pleace input right data  <a href=\"index.html\">again</a></p>\n" +
                    "</body></html>");
        }

    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int qw1Yes=0;
        int qw1No=0;
        int qw2Yes=0;
        int qw2No=0;
        String qw1Answer = request.getParameter("q1");
        if (qw1Answer.equals("yes")) {
            qw1Yes++;
        } else {
            qw1No++;
        }
        String qw2Answer = request.getParameter("q2");
        if (qw2Answer.equals("yes")) {
            qw2Yes++;
        } else {
            qw2No++;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("person1", person);
        response.sendRedirect("Stat.jsp");

        //response.getWriter().print(person + "/nAnswered for next questions /n 1. Do you like girls? /n answered /n Yes is " + qw1Yes + "/n No is " + qw1No + " " + qw2Yes +qw2No );
    }
}
