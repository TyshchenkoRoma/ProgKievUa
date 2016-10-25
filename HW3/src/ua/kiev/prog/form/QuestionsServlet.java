package ua.kiev.prog.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by roman on 25.10.16.
 */
@WebServlet(name = "QuestionsServlet")
public class QuestionsServlet extends HttpServlet {
    String ANSWER_FIRST_QW;
    String ANSWER_SECOND_QW;
    int q1Yes, q1No, q2Yes, q2No;
   // LoginServlet loginServlet = new LoginServlet();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        ANSWER_FIRST_QW = request.getParameter("q1");
        if (ANSWER_FIRST_QW.equals("yes")) {
            q1Yes++;
        } else {
            q1No++;
        }
        ANSWER_SECOND_QW = request.getParameter("q2");
        if (ANSWER_SECOND_QW.equals("yes")) {
            q2Yes++;
        } else {
            q2No++;
        }
        response.getWriter().println(q1Yes+" "+ q1No + "age =  "   );
        response.getWriter().println(firstName+" "+ lastName + "age =  " + age +  " " + q1No + "q1" + q1Yes );
//        ANSWER_FIRST_QW = request.getParameter("q1");
//        if (ANSWER_FIRST_QW.equals("yes")) {
//            q1Yes++;
//        } else {
//            q1No++;
//        }
//        ANSWER_SECOND_QW = request.getParameter("q2");
//        if (ANSWER_SECOND_QW.equals("yes")) {
//            q2Yes++;
//        } else {
//            q2No++;
//        }
//        response.getWriter().println(q1Yes+" "+ q1No + "age =  "   );
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String age = request.getParameter("age");
//        ANSWER_FIRST_QW = request.getParameter("q1");
//        if (ANSWER_FIRST_QW.equals("yes")) {
//            q1Yes++;
//        } else {
//            q1No++;
//        }
//        ANSWER_SECOND_QW = request.getParameter("q2");
//        if (ANSWER_SECOND_QW.equals("yes")) {
//            q2Yes++;
//        } else {
//            q2No++;
//        }
//        response.getWriter().println(q1Yes+" "+ q1No + "age =  "   );
//        response.getWriter().println(firstName+" "+ lastName + "age =  " + age +  " " + q1No + "q" );
    }
}
