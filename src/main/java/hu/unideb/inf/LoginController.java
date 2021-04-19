package hu.unideb.inf;

import DataBase.InsertUpdateDelete;
import DataBase.Select;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.*;

public class LoginController implements Initializable {

    @FXML private TextField usernameText;//username
    @FXML private TextField phoneNumber;//password
    @FXML private ImageView brandImageView;//left Picture
    @FXML private ImageView agreeView;//tiny right logo
    @FXML private RadioButton rbNew;//tiny right logo
    @FXML private RadioButton rbExist;//tiny right logo
    @FXML private Button NextButton;//to navigate to next page
    @FXML private Label loginMessageLabel;//if you press login w' wrong pass it says try again
    @FXML private Button cancelButton;//if u click cancel the window closes
    @FXML private Stage stage;
    @FXML private Parent scene;


    @FXML
    void loginButtonOnAction(ActionEvent event) {
        String name = usernameText.getText();
        String phone = phoneNumber.getText();

        //make sure username and pass isn't blank
        if (name.equals("") || phone.equals("")) {
            loginMessageLabel.setText("All fields are required!");
        } else if (name.equals("Zen4") && phone.equals("1234")) {
            //this has to be changed after setting up admin setting
            JOptionPane.showMessageDialog(null, "Welcome admin!");
        } else {
            if (rbNew.isSelected()) {
                String Query;
                Query = "insert into users values('" + name + "','" + phone + "')";
                //InsertUpdateDelete.setData(Query, "Welcome new customer!");
                try {
                    //this has to be changed after we add new UI for actual project
                    JOptionPane.showMessageDialog(null, "Most welcomed new user!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else if (rbExist.isSelected()) {
                //ResultSet rs = Select.getData("SELECT* FROM users where name=' "+name+" '  'and phone='" + phone + "'");
                try {
                        //this has to be changed after we add new UI for actual project
                        JOptionPane.showMessageDialog(null, "Welcome back, we missed you!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                loginMessageLabel.setText("All fields are required!");
            }
        }
    }

    @FXML
    void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    void NextpageOnAction(ActionEvent event) throws IOException {
       stage = (Stage) NextButton.getScene().getWindow();
       scene = FXMLLoader.load(getClass().getResource("/fxml/washOrDry.fxml"));
       stage.setScene(new Scene(scene));
       stage.show();
    }




    @Override //image initialization
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/sideFile.PNG"); //left image
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandImageView.setImage(brandingImage);
        File lockFile = new File("Images/agree.png"); //agree image
        Image agree = new Image(lockFile.toURI().toString());
        agreeView.setImage(agree);
    }
}










