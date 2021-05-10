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


public class Washing implements Initializable {


    @FXML private ImageView brandImageView;//
    @FXML private ImageView agreeView;//
    @FXML private TextField Date;
    @FXML private ComboBox ItemWeight;
    @FXML private ComboBox FabricType;
    @FXML private ComboBox FabricColor;
    @FXML private ComboBox WashingTemperature;
    @FXML private ComboBox Softeners;
    @FXML private Button Close;
    @FXML private Button GoBack;
    @FXML private TextField Price;
    @FXML private TextField Time;

    ObservableList<String> WeightList = FXCollections.observableArrayList("6 Kg","11 Kg","16 Kg");
    ObservableList<String> FabricTypeList = FXCollections.observableArrayList("Cotton","Synthetics","Other (Delicate)");
    ObservableList<String> ColorList = FXCollections.observableArrayList("Colored","White");
    ObservableList<String> TemperatureList = FXCollections.observableArrayList("30 Degrees","40 Degrees","60 Degrees","20-30 Degrees");
    ObservableList<String> SoftenerList = FXCollections.observableArrayList("Tablet","Liquid","Powder","No Need");


    public void GoBackButton(MouseEvent mouseEvent) throws IOException {
        Stage Backtomain = (Stage) GoBack.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/washOrDry.fxml"));
        Scene scene = new Scene(root1);
        Backtomain.setScene(scene);
        Backtomain.setResizable(false);
        Backtomain.show();
    }

    String weight;
    String type;
    String color;
    String soft;
    String temp;
    String price;
    String time;

    public void WashDetails(){
        WashingTemperature.getItems().clear();
        weight = (String) ItemWeight.getSelectionModel().getSelectedItem().toString();
        type = (String) FabricType.getSelectionModel().getSelectedItem().toString();
        color=(String) FabricColor.getSelectionModel().getSelectedItem().toString();

        try{
            ResultSet rs = Select.getData("select *from wash where weight='"+weight+"' and type='"+type+"' and color='"+color+"' ");
            while (rs.next()){
                WashingTemperature.getItems().add (rs.getString(4));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void setScene(Scene scene) {
    }

    public static void setTitle(String washing) {
    }

    public static void setResizable(boolean b) {
    }

    public static void show() {
    }


  

    public void NextButton(MouseEvent mouseEvent) {
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal =Calendar.getInstance();
        Date.setText(myFormat.format(cal.getTime()));



        ItemWeight.setItems(WeightList);
        FabricType.setItems(FabricTypeList);
        FabricColor.setItems(ColorList);
        WashingTemperature.setItems(TemperatureList);
        Softeners.setItems(SoftenerList);

    }


    public void CloseButton(MouseEvent mouseEvent) {
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to exit", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }

    public void choose(ActionEvent actionEvent) {
        weight = ItemWeight.getSelectionModel().getSelectedItem().toString();
        try{
            ResultSet rs = Select.getData("select *from wash where weight ='"+weight+"' ");
            while (rs.next()){
                Price.setText(rs.getString(6));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void tempSelect(ActionEvent actionEvent) {
        type = FabricType.getSelectionModel().getSelectedItem().toString();
        temp = WashingTemperature.getSelectionModel().getSelectedItem().toString();
        try{
            ResultSet rs = Select.getData("select *from wash where type ='"+type+"'and Temp='"+temp+"' ");
            while (rs.next()){
                Time.setText(rs.getString(7));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void colorchoose(ActionEvent actionEvent) {

    }

    public void fabtricchoose(ActionEvent actionEvent) {

    }
}
