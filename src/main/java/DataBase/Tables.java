package DataBase;

import java.sql.*;
import javax.swing.*;

public class Tables {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            st.executeUpdate("create table users(name varchar(200), phone varchar(50), status varchar (20))");
            st.executeUpdate("create table wash( weight varchar(200), type varchar(50), color varchar (20),Temp varchar(200), softener varchar(50), price varchar (20),time varchar (20))");
            JOptionPane.showMessageDialog(null, "Table Created Successfully");
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
