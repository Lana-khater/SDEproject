package mainANDcontrollers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javax.swing.*;

import static org.junit.Assert.*;

public class LoginTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Login test");
            stage.show();

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
    @Test
    public void testAdmin(){
        clickOn("#usernameText").write("Zen4");
        clickOn("#phoneNumber").write("1234");
        clickOn("#rbExist");
        clickOn("#loginButton");
        Node alert = lookup(".dialog-pane").query();
        DialogPane pane = (DialogPane) alert;
        Assertions.assertThat(pane).isVisible();
        Assertions.assertThat(pane.getContentText()).hasToString("Welcome admin!");
    }
    @Test
    public void testNonExistUser(){
        clickOn("#usernameText").write("JBCAKNA");
        clickOn("#phoneNumber").write("askbcak");
        clickOn("#rbExist");
        clickOn("#loginButton");
        Node alert = lookup(".dialog-pane").query();
        DialogPane pane = (DialogPane) alert;
        Assertions.assertThat(pane).isVisible();
        Assertions.assertThat(pane.getContentText()).hasToString("Incorrect Name or Phone!");
    }
    @Test
    public void testExistUser(){
        clickOn("#usernameText").write("Waleed");
        clickOn("#phoneNumber").write("123456");
        clickOn("#rbExist");
        clickOn("#loginButton");
        Node alert = lookup(".dialog-pane").query();
        DialogPane pane = (DialogPane) alert;
        Assertions.assertThat(pane).isVisible();
        Assertions.assertThat(pane.getContentText()).hasToString("Wait for Admin Approval");
    }
    @Test
    public void testNewUser(){
        clickOn("#usernameText").write("Hello");
        clickOn("#phoneNumber").write("Hello");
        clickOn("#rbNew");
        clickOn("#loginButton");
        Node alert = lookup(".dialog-pane").query();
        DialogPane pane = (DialogPane) alert;
        Assertions.assertThat(pane).isVisible();
        Assertions.assertThat(pane.getContentText()).hasToString("Welcome new customer!");
    }

}