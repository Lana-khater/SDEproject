package hu.unideb.inf;

import DataBase.InsertUpdateDelete;
import DataBase.Select;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import DataBase.InsertUpdateDelete;

import javax.swing.*;

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
    @FXML//tiny right logo
    private RadioButton rbNew;
    @FXML//tiny right logo
    private RadioButton rbExist;


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
        String name = usernameText.getText();
        String phone = phoneNumber.getText();

        //make sure username and pass isn't blank
        if(name.equals("") || phone.equals("")){
            loginMessageLabel.setText("All fields are required!");

        }else if (name.equals("Zen4") && phone.equals("1234")){
            //this has to be changed after setting up admin setting
            JOptionPane.showMessageDialog(null, "Welcome admin!");
        }else{
            if(rbNew.isSelected()){
            String Query;
            Query = "insert into users values('"+name+"','"+phone+"')";
            InsertUpdateDelete.setData(Query,"Welcome new customer!");
            }else if (rbExist.isSelected()){
                ResultSet rs = Select.getData("SELECT* FROM users where name='"+name+"'and phone='"+phone+"'");
                try {
                    if (rs.next()) {
                        //this has to be changed after we add new UI for actual project
                        JOptionPane.showMessageDialog(null, "Welcome existing user!");
                    }
                }catch (Exception e){
                        JOptionPane.showMessageDialog(null, e);
                }
            }else{
                loginMessageLabel.setText("All fields are required!");
            }
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




