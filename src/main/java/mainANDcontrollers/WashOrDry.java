package mainANDcontrollers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class WashOrDry{


    @FXML private Label label;
    @FXML private Button washingButton;
    @FXML private Button dryingButton;


    @FXML
    void washingButtonAction(ActionEvent event) throws IOException {
        Stage Washing = (Stage) washingButton.getScene().getWindow();
        Parent root2 = FXMLLoader.load(getClass().getResource("/fxml/Washing.fxml"));
        Scene scene = new Scene(root2);
        Washing.setScene(scene);
        Washing.setTitle("Washing");
        Washing.setResizable(false);
        Washing.show();
    }


    @FXML
    void dryingButtonAction(ActionEvent event) throws IOException {
        Stage dryingANDprice = (Stage) dryingButton.getScene().getWindow();
        Parent root5 = FXMLLoader.load(getClass().getResource("/fxml/Drying.fxml"));
        Scene scene = new Scene(root5);
        dryingANDprice.setScene(scene);
        dryingANDprice.setTitle("Fabric type");
        dryingANDprice.setResizable(false);
        dryingANDprice.show();
    }



}
