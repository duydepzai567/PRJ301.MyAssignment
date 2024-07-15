/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.exam;

import controller.Support.StudentDBContext;
import controller.Support.GradeDBContext;
import controller.Support.ExamDBContext;
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
import model.Exam;
import java.util.ArrayList;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String examIdParam = request.getParameter("eid");
        String studentIdParam = request.getParameter("sid");

        if (examIdParam != null && studentIdParam != null) {
            try {
                int eid = Integer.parseInt(examIdParam);
                int sid = Integer.parseInt(studentIdParam);

                // Retrieve grades from the database
                GradeDBContext gradeDB = new GradeDBContext();
                ArrayList<Grades> grades = gradeDB.getGradesByExamStudent(eid, sid);

                // Set grades as a request attribute and forward to JSP
                request.setAttribute("grades", grades);
                request.getRequestDispatcher("../exam/grade.jsp").forward(request, response);

            } catch (NumberFormatException e) {
                // Handle invalid input
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid exam or student ID.");
            }
        } else {
            // Handle missing parameters
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing exam or student ID.");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               doGet(request, response);
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

