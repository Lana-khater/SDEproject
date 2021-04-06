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
    private TextField phoneNumber;
    @FXML//left Picture
    private ImageView brandImageView;
    @FXML//tiny right logo
    private ImageView agreeView;

    @Override //image initialization
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/sideFile.PNG"); //left image
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandImageView.setImage(brandingImage);

        File lockFile = new File("Images/agree.png"); //agree image
        Image agree = new Image(lockFile.toURI().toString());
        agreeView.setImage(agree);
    }



    @FXML //if you press login w' wrong pass it says try again
    private Label loginMessageLabel;

    public void loginButtonOnAction (ActionEvent event){
        //make sure username and pass isnt blank
        if(usernameText.getText().isBlank() == true && phoneNumber.getText().isBlank() == true){
            loginMessageLabel.setText("Please try again!");
            //validate login should be instead of the please try again
            //when we do the databases we will remove it
            //validateLogin();
        }else if(usernameText.getText().isBlank() == false && phoneNumber.getText().isEmpty() == true){
            loginMessageLabel.setText("Please try again!");
        }
        else{
            loginMessageLabel.setText("Welcome, Happy to help you!");
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




