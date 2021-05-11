package mainANDcontrollers;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import DataBase.Tables;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Application;
import DataBase.InsertUpdateDelete;
import DataBase.Select;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.security.auth.Refreshable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.ComponentView;
import javax.swing.text.View;
import javax.xml.transform.Result;
import javafx.scene.control.TableView;
import static javafx.fxml.FXMLLoader.load;
import static javafx.fxml.FXMLLoader.setDefaultClassLoader;
import static javax.swing.JTable.getDefaultLocale;
import javafx.scene.control.TextField;
import static javax.swing.JTextField.*;
import static javax.swing.JComponent.*;



public class Drying<TakeName> implements Initializable {

    @FXML private TextField price;
    @FXML private ComboBox itemweight;
    @FXML private ComboBox fabrictype;
    @FXML private ComboBox temperature;
    @FXML private Button close;
    @FXML private Button back;
    @FXML private Button next;
    @FXML private TextField time;
    @FXML private TextField date;
    @FXML private TextField name;
    @FXML private TextField phone;


    ObservableList<String> weightlist = FXCollections.observableArrayList("11 Kg","16 Kg");
    ObservableList<String> fabrictypeList = FXCollections.observableArrayList("Cotton","Synthetics","Other (Delicates)");
    ObservableList<String> temperaturelist = FXCollections.observableArrayList("High Heat 60","Medium Heat 55","Low Gentil Heat 51");

    String Name;
    String Phone;
    String Price;
    String Time;
    String Date;
    String Weight;
    String Type;
    String Temp;


    public void backbutton(MouseEvent mouseEvent) throws IOException{
        Stage Backtomain = (Stage) back.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/washOrDry.fxml"));
        Scene scene = new Scene(root1);
        Backtomain.setScene(scene);
        Backtomain.setResizable(false);
        Backtomain.show();
    }

    public void exitbutton(MouseEvent mouseEvent) {
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to exit", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }



    public void weightselect(ActionEvent actionEvent) {
        Weight = itemweight.getSelectionModel().getSelectedItem().toString();
        try{
            ResultSet rs = Select.getData("select *from dry where weight ='"+Weight+"' ");
            while (rs.next()){
                price.setText(rs.getString(4));
                time.setText(rs.getString(5));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void nextbutton(MouseEvent mouseEvent) {
        int id =1;
        Name = name.getText();
        Phone = phone.getText();
        Price =price.getText();
        Time = time.getText();
        Date = date.getText();
        Weight = itemweight.getSelectionModel().getSelectedItem().toString();
        Type = fabrictype.getSelectionModel().getSelectedItem().toString();
        Temp = temperature.getSelectionModel().getSelectedItem().toString();
        String Query = "select max(id) from dryselect";
        try {
            ResultSet rs = Select.getData(Query);
            while (rs.next())
                id = rs.getInt(1);
            id = id+1;

            if (!price.equals("")){
                Query = "insert into dryselect(id, name, phone, weight, type, temp, price, time, date) values ("+id+", '"+Name+"', '"+Phone+"', '"+Weight+"', '"+Type+"', '"+Temp+"', '"+Price+"', '"+Time+"', '"+Date+"' )";
                InsertUpdateDelete.setData(Query, "Drying Select Successfully !");
            }

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        String path = "C:\\Users\\Haddad\\Documents\\GitHub\\SDEproject\\PDF\\Drying";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+""+id+".pdf"));
            doc.open();
            Paragraph paragraph1 = new Paragraph("                                            WELCOME TO ZEN4 LAUNDRY\n");
            doc.add(paragraph1);
            Paragraph paragraph2 = new Paragraph("****************************************************************************************************************");
            doc.add(paragraph2);
            Paragraph paragraph3 = new Paragraph("\tInvoice ID : "+id+"\nCustomer Name : "+Name+"\nCustomer Phone N. : "+Phone+"\nToday Date : "+Date+"\n ");
            doc.add(paragraph3);
            doc.add(paragraph2);
            Paragraph paragraph4 = new Paragraph("\tDrying Details :\nItem Weight : "+Weight+"\nFabric Type : "+Type+"\nDrying Temperature : "+Temp+"\n");
            doc.add(paragraph4);
            doc.add(paragraph2);
            PdfPTable tb1= new PdfPTable(2);
            tb1.addCell(" Total Amount : "+Price);
            tb1.addCell(" Time Needed To Finish : "+Time);
            doc.add(tb1);
            doc.add(paragraph2);
            Paragraph paragraph5 = new Paragraph("                                    You Will Receive An SMS After : "+Time+"\n");
            doc.add(paragraph5);
            doc.add(paragraph2);
            doc.add(paragraph2);
            Paragraph paragraph6 = new Paragraph("                                       Thank You, Please Visit Us Again.\n");
            doc.add(paragraph6);
        }
        catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        int a = JOptionPane.showConfirmDialog(null,"Do You Want To Print Invoice","Select",JOptionPane.YES_NO_OPTION);
        if (a==0){
            try {
                if ((new File("C:\\Users\\Haddad\\Documents\\GitHub\\SDEproject\\PDF\\Drying"+id+".pdf")).exists()) {
                    Process p = Runtime
                            .getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\Haddad\\Documents\\GitHub\\SDEproject\\PDF\\Drying"+id+".pdf");
                }
                else {
                    System.out.println("File is not Exists");
                }

            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal =Calendar.getInstance();
        date.setText(myFormat.format(cal.getTime()));
        itemweight.setItems(weightlist);
        fabrictype.setItems(fabrictypeList);
        temperature.setItems(temperaturelist);



    }
}
