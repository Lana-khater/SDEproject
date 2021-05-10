/*package mainANDcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;


public class DandFabric {

    ObservableList<String> FabrictypeList = FXCollections.observableArrayList("Cotton","Synthetics","Others(delicates)");



    @FXML private ComboBox Selector;
    @FXML private Button BackButton;
    @FXML private Button Next2Button;

    public void NextOnAction(ActionEvent event) throws IOException {
        Stage dryandprice = (Stage) Next2Button.getScene().getWindow();
        Parent root7 = FXMLLoader.load(getClass().getResource("/fxml/dandP.fxml"));
        Scene scene = new Scene(root7);
        dryandprice.setScene(scene);
        dryandprice.setResizable(false);
        dryandprice.setTitle("Capacity and Prices");
        dryandprice.show();
    }

    public void BackOnAction(ActionEvent event) throws IOException {
        Stage washordry = (Stage) BackButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/washOrDry.fxml"));
        Scene scene = new Scene(root1);
        washordry.setScene(scene);
        washordry.setResizable(false);
        washordry.setTitle("Pick One");
        washordry.show();
    }

    @FXML
    private void initialize(){
        Selector.setValue("Cotton");
        Selector.setItems(FabrictypeList);
    }



}
*/