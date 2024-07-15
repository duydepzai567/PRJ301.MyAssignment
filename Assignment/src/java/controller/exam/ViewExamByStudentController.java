package controller.exam;

import controller.Support.SubjectsDBContext;
import model.Subject;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewExamByStudentController", urlPatterns = {"/exam/schedule"})
public class ViewExamByStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String subidStr = request.getParameter("subid");
        int subid = Integer.parseInt(subidStr);
        
        // Create an instance of the database context
        SubjectsDBContext dbContext = new SubjectsDBContext();
        
        // Fetch the list of subjects based on the given subject ID
        ArrayList<Subject> subjects = dbContext.getSubjectsBySubjectId(subid);
        
        // Set the subjects list as an attribute in the request
        request.setAttribute("subjects", subjects);
        
        request.getRequestDispatcher("../exam/schedule.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
