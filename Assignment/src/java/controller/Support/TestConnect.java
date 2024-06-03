package controller.Support;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TestConnect {
    public static void main(String[] args){    
    DBSupport db = new DBSupport();
        try {
            Connection connect = db.getConnection();
            System.out.println("Success.");
        } catch (ClassNotFoundException ex) {
         System.out.println("No driver found.");
        } catch (SQLException ex) {
        System.out.println("No suitable database.");
        }
}
}