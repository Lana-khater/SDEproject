package DataBase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/TrVPLGTbDS","TrVPLGTbDS","IQVjKFF4My");
            return con;
        }catch (Exception e){
            return null;
        }
    }
}
