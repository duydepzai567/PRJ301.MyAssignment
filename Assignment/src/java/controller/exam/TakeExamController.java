package controller.exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Exam;
import model.Grades;
import model.Student;
import model.Account;
import controller.Support.ExamDBContext;
import controller.Support.GradeDBContext;
import controller.Support.StudentDBContext;
import model.Lecturer;
import controller.lio.BaseRequiredLecturerAuthenticationController;

@WebServlet(name = "TakeExamController", urlPatterns = {"/exam/take"})
public class TakeExamController extends BaseRequiredLecturerAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account, Lecturer lecturer)
        throws ServletException, IOException {
    String cidParam = request.getParameter("cid");
    if (cidParam != null) {
        try {
            int cid = Integer.parseInt(cidParam);
            
            StudentDBContext stuDB = new StudentDBContext();
            ExamDBContext examDB = new ExamDBContext();
            GradeDBContext graDB = new GradeDBContext();

            ArrayList<Student> students = stuDB.getStudentsByCourse(cid);

            String[] raw_eids = request.getParameterValues("eid");
            ArrayList<Integer> eids = new ArrayList<>();
            for (String raw_eid : raw_eids) {
                eids.add(Integer.parseInt(raw_eid));
            }

            ArrayList<Exam> exams = examDB.getExamsByExamIds(eids);
            ArrayList<Grades> grades = graDB.getGradesFromExamIds(eids);

            request.setAttribute("students", students);
            request.setAttribute("exams", exams);
            request.setAttribute("grades", grades);

            request.getRequestDispatcher("../exam/take.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Handle number format exception
            e.printStackTrace();  // Log the exception for debugging
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameter format");
        }
    } else {
        // Handle case where cid parameter is missing
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Course ID parameter is missing");
    }
}


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account, Lecturer lecturer)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        HashSet<Integer> eids = new HashSet<>();

        ArrayList<Grades> grades = new ArrayList<>();

        String[] raw_gradeids = request.getParameterValues("gradeid");
        for (String raw_gradeid : raw_gradeids) {
            int sid = Integer.parseInt(raw_gradeid.split("_")[0]);
            int eid = Integer.parseInt(raw_gradeid.split("_")[1]);

            eids.add(eid);

            String raw_score = request.getParameter("score" + sid + "_" + eid);
            if (raw_score != null && !raw_score.isEmpty()) {
                try {
                    float score = Float.parseFloat(raw_score);

                    Grades g = new Grades();
                    Exam e = new Exam();
                    e.setId(eid);

                    Student s = new Student();
                    s.setId(sid);

                    g.setExam(e);
                    g.setStudent(s);
                    g.setScore(score);

                    grades.add(g);
                } catch (NumberFormatException e) {
                    // Handle parsing error if necessary
                    e.printStackTrace();  // Log or handle the exception
                }
            }
        }

        GradeDBContext db = new GradeDBContext();
        db.insertGradesForCourse(cid, grades);

        StringBuilder urlParams = new StringBuilder();
        for (Integer eid : eids) {
            urlParams.append("&eid=").append(eid);
        }
        response.sendRedirect("take?cid=" + cid + urlParams.toString());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
