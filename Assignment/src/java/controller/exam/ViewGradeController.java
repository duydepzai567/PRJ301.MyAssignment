/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.exam;

import controller.Support.CourseDBContext;
import controller.Support.StudentDBContext;
import controller.Support.GradeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import controller.Support.AccountDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import model.Grades;
import model.Account;
import java.util.ArrayList;
import model.Course;

/**
 *
 * @author DUCDUY2003
 */
@WebServlet(name = "ViewGradeController", urlPatterns = {"/exam/grade"})
public class ViewGradeController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Student student)
            throws ServletException, IOException {
        CourseDBContext db = new CourseDBContext();
        int sid = student.getId();
        ArrayList<Course> courses = db.getCoursesByLecturer(sid);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("../exam/grade.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Student student)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int sid = student.getId();
        GradeDBContext db = new GradeDBContext();
        request.getRequestDispatcher("../exam/grade.jsp").forward(request, response);

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

