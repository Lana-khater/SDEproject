package hu.unideb.inf;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Screen;

public class FabricController implements Initializable {
    @FXML private Label ChooseLabel;
    @FXML private RadioButton yesbtn;
    @FXML private RadioButton nobtn;


   ObservableList list= FXCollections.observableArrayList(//"cotton, synthetics , otherss"); //Fabric type
    @FXML private ChoiceBox<String> fabricType;
    private void fabricType(){
        list.removeAll(list);
        String a= "Cotton";
        String b= "Synthetics";
        String c= "Others (Delicates)";
        list.addAll(a,b,c);
        fabricType.getItems().addAll(list);}


    ObservableList list2= FXCollections.observableArrayList(); //Fabric color
    @FXML private ChoiceBox<String> fabricColor;
    private void fabricColor (){
        list2.removeAll(list2);
        String d="Colored";
        String e="Whites";
        list2.addAll(d,e);
        fabricColor.getItems().addAll(list2);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fabricType();
      fabricColor();
        //fabricType.getItems().add("Cotton");
       // fabricType.getItems().add("Synthetics");
       // fabricType.getItems().add("others(delicates)");

    }

    }

