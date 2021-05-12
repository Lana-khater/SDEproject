package DataBase;

import javafx.scene.control.Alert;
import mainANDcontrollers.ViewUtil;

import javax.swing.*;
import java.sql.*;

public class InsertUpdateDelete {
    public static void setData(String Query,String msg){
        Connection con = null;
        Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals(""))
                ViewUtil.createAlert(Alert.AlertType.INFORMATION, msg).showAndWait();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try{}
            catch (Exception e){}
        }
    }
}
