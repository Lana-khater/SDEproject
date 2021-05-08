package mainANDcontrollers;

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;


public class MainApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Parent root0 = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene scene = new Scene(root0);
        stage.setScene(scene);
        stage.setTitle("Welcome Here");
        stage.setResizable(false);
        stage.show();


    }

    public static void main(String[] args) {

        launch(args);
    }

}


//stage.initStyle(StageStyle.UNDECORATED); //no window outline
//stage.setScene(new Scene(root, 550,405)); //window size
//Scene.getStylesheets().add("/styles/Styles.css");//put it in when we start CSS
