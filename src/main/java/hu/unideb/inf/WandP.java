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
    @FXML private CheckBox one;
    @FXML private CheckBox two;
    @FXML private CheckBox three;
    @FXML private ImageView whitetee;


@FXML
public void oneOnAction(ActionEvent event){
if(one.isSelected()){
   one.setText("1500 FORINTS!");
   two.setSelected(false); //makes the other checkboxes not ticked
   three.setSelected(false);
}
}
@FXML
public void twoOnAction(ActionEvent event){
    if(two.isSelected()){
        two.setText("2500 FORINTS!");
        one.setSelected(false);
        three.setSelected(false);
        }}


    @FXML
    public void threeOnAction(ActionEvent event){
        if(three.isSelected()){
            three.setText("3000 FORINTS!");
        one.setSelected(false);
        two.setSelected(false );}
    }



  /*  @Override
    public void initialize(URL url, ResourceBundle rb) {
        File brandingFile = new File("images/wandp1.jpg");
        Image WashImage = new Image(brandingFile.toURI().toString());
        whitetee.setImage(WashImage);
        //cehck this */




}
}
