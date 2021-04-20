package hu.unideb.inf;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WandP implements Initializable{
    @FXML private Label chooseTextLabel;
    @FXML private Label sixKG;
    @FXML private Label elevenKG;
    @FXML private Label sixteenKG;
    @FXML private CheckBox oneHUF;
    @FXML private CheckBox twoHUF;
    @FXML private CheckBox threeHUF;
    @FXML private ImageView whitetee;


@FXML
public void one(ActionEvent event){
if(oneHUF.isSelected()){
   oneHUF.setText("1500 FORINTS!");
}
}
@FXML
public void two(ActionEvent event){
    if(twoHUF.isSelected()){
        twoHUF.setText("2500 FORINTS!");
        }}


    @FXML
    public void three (ActionEvent event){
        if(threeHUF.isSelected()){
            threeHUF.setText("3000 FORINTS!"); }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File brandingFile = new File("images/wandp1.jpg");
        Image WashImage = new Image(brandingFile.toURI().toString());
        whitetee.setImage(WashImage);
        //cehck this




}
}
