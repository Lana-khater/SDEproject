package mainANDcontrollers;

import javafx.application.Application;
import DataBase.InsertUpdateDelete;
import DataBase.Select;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.swing.*;

import static javafx.fxml.FXMLLoader.load;
import static javafx.fxml.FXMLLoader.setDefaultClassLoader;

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





    @FXML
    void loginButtonOnAction(ActionEvent event) throws IOException {
        int check=0;
        String name = usernameText.getText();
        String phone = phoneNumber.getText();

        //make sure username and pass isn't blank
        if (name.equals("") || phone.equals("")) {
            check =1;
            loginMessageLabel.setText("All fields are required!");

        } else {
            if (rbNew.isSelected()) {
                String Query;
                Query = "insert into users values('" + name + "','" + phone + "', 'false')";
                InsertUpdateDelete.setData(Query, "Welcome new customer!");

            } else if (rbExist.isSelected()) {
                if (name.equals("Zen4") && phone.equals("1234")) {
                    check=1;
                    Stage adminhome = (Stage) rbExist.getScene().getWindow();
                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/adminHome.fxml"));
                    Scene scene = new Scene(root1);
                    adminhome.setScene(scene);
                    adminhome.setResizable(false);
                    adminhome.setTitle("Welcome admin");
                    adminhome.show();
                    JOptionPane.showMessageDialog(null, "Welcome admin!");
                }
                else {
                    ResultSet rs=Select.getData("select *from users where name= '"+name+"' and phone='"+phone+"'");
                    try
                    {
                        if(rs.next()){
                            check=1;
                            if (rs.getString(3).equals("true")){
                                NextpageOnAction(event);
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Wait for Admin Approval");
                        }
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e);
                    }
                }
                if (check==0)
                    JOptionPane.showMessageDialog(null, "Incorrect Name or Phone!");
            }
        }
    }

    @FXML
    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

  //swtich to scene 2
  public void NextpageOnAction(ActionEvent event) throws IOException {
      int check=0;
      String name = usernameText.getText();
      String phone = phoneNumber.getText();
      if (name.equals("") || phone.equals("")) {
          check = 1;
          JOptionPane.showMessageDialog(null,"Login First!");
      } else {
         // Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
          Stage washordry = (Stage) NextButton.getScene().getWindow();
          Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/washOrDry.fxml"));
          Scene scene = new Scene(root1);
          washordry.setScene(scene);
          washordry.setResizable(false);
          washordry.setTitle("Pick One");
          washordry.show();
      }
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











