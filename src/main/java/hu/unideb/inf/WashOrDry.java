package hu.unideb.inf;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WashOrDry implements Initializable {

    @FXML
    private ImageView backgroundView;
    @FXML
    private Label label;
    @FXML
    private Button washingButton;
    @FXML
    private Button dryingButton;

    public WashOrDry(ImageView backgroundView, Label label, Button washingButton, Button dryingButton) {
        this.backgroundView = backgroundView;
        this.label = label;
        this.washingButton = washingButton;
        this.dryingButton = dryingButton;
    }


    @FXML
    public void washingButtonAction(ActionEvent event) {
        if(washingButton.isPressed())
            label.setText("Proceeding with washing, $$");
    }
    @FXML
    public void dryingButtonAction(ActionEvent event) {
        if(dryingButton.isPressed())
            label.setText("Proceeding with drying, $");
    }



    public void initialize(URL url, ResourceBundle rb) {
        File brandingFile = new File("images/allinOne.PNG");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        this.backgroundView.setImage(brandingImage);
    }

}