package DataBase;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;

public class Tables {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            st.executeUpdate("create table users(name varchar(200), phone varchar(50))");
            JOptionPane.showMessageDialog(null, "Table created successfully");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try{
                con.close();
                st.close();
            }
            catch (Exception e){}
        }
    }
}
