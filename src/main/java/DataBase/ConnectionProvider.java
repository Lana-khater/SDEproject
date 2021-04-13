package DataBase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection getCon() {
        try {
            String host = "jdbc:mysql://localhost:3306/laundry";
            String uName = "root";
            String uPass = "1234";
            Connection con = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return null;
    }
}
