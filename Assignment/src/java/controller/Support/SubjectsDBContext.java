/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Support;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Subject;
import model.Assessment;
import model.Exam;
import java.sql.Connection;

/**
 *
 * @author DUCDUY2003
 */
public class SubjectsDBContext extends DBContext<Subject> {

    public ArrayList<Subject> getSubjectsBySubjectId(int subid) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String sql = "SELECT s.[subid],s.[subname],a.[aname],e.[from]\n"
                + "FROM [dbo].[subjects] s\n"
                + "INNER JOIN [dbo].[assesments] a ON s.[subid] = a.[aid]\n"
                + "INNER JOIN [dbo].[exams] e ON a.[aid] = e.[eid]\n"
                + "where s.subid = '1' " ;
        try (Connection connection = getConnection(); PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setInt(1, subid);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setId(rs.getInt("subid"));
                    subject.setName(rs.getString("subname"));

                    Assessment assessment = new Assessment();
                    assessment.setName(rs.getString("aname"));

                    Exam exam = new Exam();
                    exam.setFrom(rs.getDate("from"));

                    // Assuming Subject class has methods to add assessments and exams
                    subjects.addAll(subjects);
                    subjects.add(subject);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectsDBContext.class.getName()).log(Level.SEVERE, "Error fetching subjects", ex);
        }
        return subjects;
    }

    @Override
    public void insert(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subject get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Subject> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
