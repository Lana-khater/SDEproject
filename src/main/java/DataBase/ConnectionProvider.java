package DataBase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry","root","Zen4");
            return con;
        }catch (Exception e){
            return null;
        }
    }
}
