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

/**
 *
 * @author DUCDUY2003
 */
public class SubjectsDBContext extends DBContext<Subject> {

    public ArrayList<Subject> getSubjectsByCourse(int cid) {
        ArrayList<Subject> subject = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT \n"
                    + "    s.[subid],\n"
                    + "    s.[subname],\n"
                    + "    a.[aname],\n"
                    + "    e.[from]\n"
                    + "FROM [dbo].[subjects] s\n"
                    + "INNER JOIN [dbo].[assesments] a ON s.[subid] = a.[subid]\n"
                    + "INNER JOIN [dbo].[exams] e ON a.[aid] = e.[aid]";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                subject.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SubjectsDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return subject;
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

}
