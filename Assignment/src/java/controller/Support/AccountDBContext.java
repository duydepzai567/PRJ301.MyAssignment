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
import model.Account;
import model.Lecturer;

/**
 *
 * @author DUCDUY2003
 */
public class AccountDBContext extends DBContext<Account> {

    public Account getAccountByUsernamePassword(String username, String password) {
        PreparedStatement stm = null;
        Account account = null;
        try {
            String sql = "SELECT acct.username,\n"
                    + "		acct.displayname,\n"
                    + "		l.lid,\n"
                    + "		l.lname\n"
                    + "FROM [dbo].[Account] acct LEFT JOIN user_lecturers ul ON ul.username = acct.username AND ul.active = 1\n"
                    + "LEFT JOIN lecturers l ON ul.lid = l.lid\n"
                    + "WHERE acct.username = ? AND acct.[password] = ?";

            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setDisplayname(rs.getString("displayname"));
                account.setUsername(username);
                int lid = rs.getInt("lid");
                if (lid != 0) {
                    Lecturer lecturer = new Lecturer();
                    lecturer.setId(lid);
                    lecturer.setName(rs.getString("lname"));
                    account.setLecturer(lecturer);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return account;
    }

    @Override
    public void insert(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
