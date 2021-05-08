package mainANDcontrollers;

import DataBase.Tables;
import javafx.application.Application;
import DataBase.InsertUpdateDelete;
import DataBase.Select;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javax.security.auth.Refreshable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javafx.scene.control.TableView;
import static javafx.fxml.FXMLLoader.load;
import static javafx.fxml.FXMLLoader.setDefaultClassLoader;
import static javax.swing.JTable.getDefaultLocale;


public class Admin implements Initializable {

    @FXML
    private TableView<Users> AdminTable;
    @FXML
    private TableColumn<Users, String> nameCol;
    @FXML
    private TableColumn<Users, String> phoneCol;
    @FXML
    private TableColumn<Users, String> statusCol;

    Users users = null;


    ObservableList<Users> UserList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDate();
        
    }

    private void loadDate() {

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }


    public void exitButtonOnAction(ActionEvent actionEvent) {
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to exit", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }




    public void refreshTable(ActionEvent actionEvent) {
        UserList.clear();
        ResultSet rs = Select.getData("select *from users");
        try {
            while (rs.next()) {
                UserList.add(new Users(
                        rs.getString("name"),
                        rs.getInt("phone"),
                        rs.getString("status")));
                AdminTable.setItems(UserList);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    public void statusChange(MouseEvent mouseEvent) {
        users = AdminTable.getSelectionModel().getSelectedItem();
        String name = users.name;
        String status = users.status;
        if (status.equals("true"))
            status="false";
        else
            status="true";
        try
        {
            int a = JOptionPane.showConfirmDialog(null, "Do You Want To Change Status Of "+name+" ","Select",JOptionPane.YES_NO_OPTION);
            if (a==0) {
                InsertUpdateDelete.setData("update users set status= '"+status+"' where name= '"+name+"' ", "Status Changed Successfully");

            }
        }
        catch (Exception e) {
        }
        }

    }