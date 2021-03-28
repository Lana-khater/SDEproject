package hu.unideb.inf;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.net.URL;
import javafx.scene.control.Label;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;

public class LoginController implements Initializable {
 //buttons, images, and message label
    @FXML //username
    private TextField usernameText;
    @FXML //password
    private PasswordField passwordText;
    @FXML
    private ImageView brandImageView;
    @FXML
    private ImageView lockView;

    @Override //image initialization
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/bg.jpg"); //left image
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandImageView.setImage(brandingImage);

        File lockFile = new File("Images/lock.png"); //lock image
        Image lockImage = new Image(lockFile.toURI().toString());
        lockView.setImage(lockImage);
    }



    @FXML //if you press login w' wrong pass it says try again
    private Label loginMessageLabel;

    public void loginButtonOnAction (ActionEvent event){
        //make sure username and pass isnt blank
        if(usernameText.getText().isBlank() == false && passwordText.getText().isBlank()==false){
            loginMessageLabel.setText("Please try again!");
            //validate llogin should be instead of the please try again
            //when we do the databases we will remove it
            //validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter a username and a password!");
        }
    }


    @FXML//if u click cancel the window closes
    private Button cancelButton;
    public void cancelButtonOnAction(ActionEvent event){
       Stage stage= (Stage) cancelButton.getScene().getWindow();
       stage.close();
    }
    public  void validateLogin(){}




  /*  @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");*/
    }




