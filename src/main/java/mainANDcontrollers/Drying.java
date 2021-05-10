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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.security.auth.Refreshable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.ComponentView;
import javax.swing.text.View;
import javax.xml.transform.Result;

import javafx.scene.control.TableView;
import static javafx.fxml.FXMLLoader.load;
import static javafx.fxml.FXMLLoader.setDefaultClassLoader;
import static javax.swing.JTable.getDefaultLocale;
import javafx.scene.control.TextField;
import static javax.swing.JTextField.*;
import static javax.swing.JComponent.*;



public class Drying implements Initializable {

    @FXML private TextField price;
    @FXML private ComboBox itemweight;
    @FXML private ComboBox fabrictype;
    @FXML private ComboBox temperature;
    @FXML private Button close;
    @FXML private Button back;
    @FXML private Button next;
    @FXML private TextField time;
    @FXML private TextField date;
    String weight;
    String type;
    String temp;

    ObservableList<String> weightlist = FXCollections.observableArrayList("11 Kg","16 Kg");
    ObservableList<String> fabrictypeList = FXCollections.observableArrayList("Cotton","Synthetics","Other (Delicates)");
    ObservableList<String> temperaturelist = FXCollections.observableArrayList("High Heat 60","Medium Heat 55","Low Gentil Heat 51");

    public void backbutton(MouseEvent mouseEvent) throws IOException{
        Stage Backtomain = (Stage) back.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/washOrDry.fxml"));
        Scene scene = new Scene(root1);
        Backtomain.setScene(scene);
        Backtomain.setResizable(false);
        Backtomain.show();
    }

    public void nextbutton(MouseEvent mouseEvent) {
    }

    public void exitbutton(MouseEvent mouseEvent) {
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to exit", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal =Calendar.getInstance();
        date.setText(myFormat.format(cal.getTime()));



        itemweight.setItems(weightlist);
        fabrictype.setItems(fabrictypeList);
        temperature.setItems(temperaturelist);


    }

    public void weightselect(ActionEvent actionEvent) {
        weight = itemweight.getSelectionModel().getSelectedItem().toString();
        try{
            ResultSet rs = Select.getData("select *from dry where weight ='"+weight+"' ");
            while (rs.next()){
                price.setText(rs.getString(4));
                time.setText(rs.getString(5));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
