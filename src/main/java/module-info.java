module JavaFX11 {

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
   /* requires mysql.connector.java;*/ //when we start dealing with sql
    opens hu.unideb.inf;
}