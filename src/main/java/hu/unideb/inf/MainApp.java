package hu.unideb.inf;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

       /* stage.setTitle("SDE LOGIN");*/
        stage.initStyle(StageStyle.UNDECORATED); //no window outline
        stage.setScene(new Scene(root, 550,400)); //window size

      /*  Scene.getStylesheets().add("/styles/Styles.css");*/ //put it in when we start CSS

        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}