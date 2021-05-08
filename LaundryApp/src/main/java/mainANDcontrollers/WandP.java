
package mainANDcontrollers;

import java.awt.*;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WandP {

    @FXML private Label labels;
    @FXML private Label chooseText;
    @FXML private Label sixKG;
    @FXML private Label elevenKG;
    @FXML private Label sixteenKG;
    @FXML private CheckBox two;
    @FXML private CheckBox three;
    @FXML private CheckBox one;
    @FXML private Button ProceedButton;
    @FXML private Button BackButton;



    @FXML
    void oneHUF(ActionEvent event) {
      labels.setText("1500 FORINTS");
      //MORE TO BE ADDED WHEN SWITCHING PAGES
    }

    @FXML
    void threeHUF(ActionEvent event) {
        labels.setText("3000 FORINTS");
        //MORE TO BE ADDED WHEN SWITCHING PAGES
    }

    @FXML
    void twoHUF(ActionEvent event) {
        labels.setText("2500 FORINTS");
        //MORE TO BE ADDED WHEN SWITCHING PAGES
    }

    @FXML
    void ProceedOnAction(ActionEvent event) throws IOException {
        Stage towashFabric = (Stage) ProceedButton.getScene().getWindow();
        Parent root12 = FXMLLoader.load(getClass().getResource("/fxml/wandFabric.fxml"));
        Scene scene = new Scene(root12);
        towashFabric.setScene(scene);
        towashFabric.setResizable(false);
        towashFabric.show();
    }

    @FXML
    void BackToMainOnAction(ActionEvent event) throws IOException {
        Stage Backtomain = (Stage) BackButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/washOrDry.fxml"));
        Scene scene = new Scene(root1);
        Backtomain.setScene(scene);
        Backtomain.setResizable(false);
        Backtomain.show();
    }



}

