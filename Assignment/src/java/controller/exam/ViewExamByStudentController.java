/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.exam;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.Exam;
import model.Subject;
import model.Assessment;
import controller.Support.ExamDBContext;
import controller.Support.SubjectsDBContext;
import controller.Support.AssessmentDBContext;
import controller.lio.BaseRequiredLecturerAuthenticationController;
import jakarta.servlet.annotation.WebServlet;
import java.util.ArrayList;
import model.Student;
import model.Lecturer;

/**
 *
 * @author DUCDUY2003
 */
@WebServlet(name="ViewCourseByLecturerController", urlPatterns={"/exam/schedule"})
public class ViewExamByStudentController extends BaseRequiredLecturerAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account, Student student)
            throws ServletException, IOException {
        SubjectsDBContext db = new SubjectsDBContext();
        int sid = student.getId();
        ArrayList<Subject> subject = db.getSubjectsByCourse(sid);
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("../exam/schedule.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account, Student student)
            throws ServletException, IOException {
        int subid = Integer.parseInt(request.getParameter("subid"));
        int sid = student.getId();

        ExamDBContext db = new ExamDBContext();
        ArrayList<Exam> exams = db.getExamsByCourse(sid);
        request.setAttribute("exams", exams);

        request.getRequestDispatcher("../exam/schdule.jsp").forward(request, response);

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account, Lecturer lecturer) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account, Lecturer lecturer) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
