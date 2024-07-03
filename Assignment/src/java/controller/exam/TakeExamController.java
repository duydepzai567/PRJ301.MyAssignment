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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account user, Lecturer lecturer)
    throws ServletException, IOException {
        StudentDBContext stuDB = new StudentDBContext();
        ExamDBContext examDB = new ExamDBContext();
        GradeDBContext graDB = new GradeDBContext();
        
        int cid = Integer.parseInt(request.getParameter("cid"));
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
        request.setAttribute("grades",grades);
        
        request.getRequestDispatcher("../exam/take.jsp").forward(request, response);
        
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response,Account user, Lecturer lecturer)
    throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        HashSet<Integer> eids = new HashSet<>();
        
        String[] raw_gradeids = request.getParameterValues("gradeid");
        ArrayList<Grades> grades = new ArrayList<>();
        for (String raw_gradeid : raw_gradeids) {
          int sid = Integer.parseInt(raw_gradeid.split("_")[0]);
          int eid = Integer.parseInt(raw_gradeid.split("_")[1]);
          
          eids.add(eid);
          
          String raw_score = request.getParameter("score"+sid+"_"+eid);
          if(raw_score.length()>0)
          {
              Grades g = new Grades();
              Exam e = new Exam();
              e.setId(eid);
              
              Student s = new Student();
              s.setId(sid);
              
              g.setExam(e);
              g.setStudent(s);
              g.setScore(Float.parseFloat(raw_score));
              
              grades.add(g);
          }
        }
        
        GradeDBContext db = new GradeDBContext();
        db.insertGradesForCourse(cid, grades);
        String url_param = "";
        for (Integer eid : eids) {
            url_param+="&eid="+eid;
        }
        response.sendRedirect("take?cid="+cid+url_param);
        
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}