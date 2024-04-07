package com.example.javatda;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.sql.*;

public class HelloApplication extends Application {
    TextField tf1;
    PasswordField pf;
    TextField tf2;
    Label errorlbl;
    RadioButton rb1;
    RadioButton rb2;
    DatePicker dp;
    TextArea ta;
    ComboBox<String> cb;
    CheckBox chk1;
    CheckBox chk2;
    CheckBox chk3;
    TextField tf3;
    Label l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22;
    @Override
    public void start(Stage stage) {
        // Creating panes
        VBox pane = new VBox();
        pane.setStyle("-fx-background-color: #66ff33;");
        GridPane paneForCreate = new GridPane();
        paneForCreate.setHgap(5);
        paneForCreate.setVgap(5);
        paneForCreate.setStyle("-fx-background-color: #66ff33;");
        GridPane paneForSelect = new GridPane();
        paneForSelect.setHgap(5);
        paneForSelect.setVgap(5);
        paneForSelect.setStyle("-fx-background-color: #66ff33;");
        GridPane paneForUpdate = new GridPane();
        paneForUpdate.setHgap(5);
        paneForUpdate.setVgap(5);
        paneForUpdate.setStyle("-fx-background-color: #66ff33;");
        GridPane paneForDelete = new GridPane();
        paneForDelete.setHgap(5);
        paneForDelete.setVgap(5);
        paneForDelete.setStyle("-fx-background-color: #66ff33;");

        // Creating nodes
        Text welcomeText = new Text("Welcome! Please select the required operation from the menu bar");
        welcomeText.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC,27 ));
        welcomeText.setFill(Color.rgb(51, 51, 255));
        welcomeText.setStrokeWidth(7);

        Menu m = new Menu("Menu");
        MenuItem m1 = new MenuItem("Create");
        MenuItem m2 = new MenuItem("Update");
        MenuItem m3 = new MenuItem("Select or Read");
        MenuItem m4 = new MenuItem("Delete");
        m.getItems().addAll(m1, m2, m3, m4);
        MenuBar mb = new MenuBar();
        mb.getMenus().add(m);

        // Adding node to pane
        pane.getChildren().addAll(mb, welcomeText);

        Text txtCreate = new Text("Kindly enter the student details below for record creation");
        txtCreate.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 17 ));
        txtCreate.setFill(Color.rgb(51, 51, 255));
        txtCreate.setStrokeWidth(2);
        Text txtUpdate = new Text("Kindly enter the student details below for record updation");
        txtUpdate.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 17 ));
        txtUpdate.setFill(Color.rgb(51, 51, 255));
        txtUpdate.setStrokeWidth(2);
        Text txtSelect = new Text("Kindly enter the student details below for record selection");
        txtSelect.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 17 ));
        txtSelect.setFill(Color.rgb(51, 51, 255));
        txtSelect.setStrokeWidth(2);
        Text txtDelete = new Text("Kindly enter the student details below for record deletion");
        txtDelete.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 17 ));
        txtDelete.setFill(Color.rgb(51, 51, 255));
        txtDelete.setStrokeWidth(2);
        Label l1 = new Label("Register Number: ");
        tf1 = new TextField();
        Label l2 = new Label("Password: ");
        pf = new PasswordField();
        Label l3 = new Label("Name:");
        tf2 = new TextField();
        Label l4 = new Label("Gender:");
        rb1 = new RadioButton("Male");
        rb2 = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        rb1.setToggleGroup(genderGroup);
        rb2.setToggleGroup(genderGroup);
        Label l5 = new Label("Date of birth:");
        dp = new DatePicker();
        Label l6 = new Label("Address:");
        ta = new TextArea();
        ta.setWrapText(true);
        ScrollPane sp = new ScrollPane(ta);
        Label l7 = new Label("Branch:");
        cb = new ComboBox<>();
        cb.getItems().addAll("CSE", "IT", "ECE", "EEE", "MECH", "CHEM");
        Label l8 = new Label("Register for sports facilities: ");
        chk1 = new CheckBox("Badminton");
        chk2 = new CheckBox("Lawn Tennis");
        chk3 = new CheckBox("Swimming");
        Label l9 = new Label("Upload 12th grade marks sheet: ");
        FileChooser fc = new FileChooser();
        tf3 = new TextField();
        Button btFc = new Button("Browse");
        Button btCreate = new Button("Submit");
        Button btUpdate = new Button("Submit");
        Button btUpdate2 = new Button("Update");
        Button btSelect = new Button("Submit");
        Button btDelete = new Button("Delete");
        errorlbl = new Label();
        l10 = new Label("Registered sports facilities: ");
        l11 = new Label("File uploaded: ");
        l12 = new Label();
        l13 = new Label();
        l14 = new Label();
        l15 = new Label();
        l16 = new Label();
        l17 = new Label();
        l18 = new Label();
        l19 = new Label();
        l20 = new Label();
        l21 = new Label();
        l22 = new Label();

        m1.setOnAction((ActionEvent e) -> {
                    paneForCreate.getChildren().clear();
                    paneForCreate.add(txtCreate,0,0);
                    paneForCreate.add(l1,0,1);
                    tf1.setText("");
                    paneForCreate.add(tf1,1,1);
                    paneForCreate.add(l2,0,2);
                    pf.setText("");
                    paneForCreate.add(pf,1,2);
                    paneForCreate.add(l3,0,3);
                    tf2.setText("");
                    paneForCreate.add(tf2,1,3);
                    paneForCreate.add(l4,0,4);
                    if(rb1.isSelected()){
                        rb1.setSelected(false);
                    }else{
                        rb2.setSelected(false);
                    }
                    paneForCreate.add(rb1,1,4);
                    paneForCreate.add(rb2, 2,4);
                    paneForCreate.add(l5,0,5);
                    dp.setValue(null);
                    paneForCreate.add(dp,1,5);
                    paneForCreate.add(l6,0,6);
                    ta.setText("");
                    paneForCreate.add(sp,1,6);
                    paneForCreate.add(l7,0,7);
                    cb.setValue(null);
                    paneForCreate.add(cb,1,7);
                    paneForCreate.add(l8,0,8);
                    if(chk1.isSelected()){
                        chk1.setSelected(false);
                    }
                    if(chk2.isSelected()){
                        chk2.setSelected(false);
                    }
                    if(chk3.isSelected()){
                        chk3.setSelected(false);
                    }
                    paneForCreate.add(chk1,1,8);
                    paneForCreate.add(chk2,1,9);
                    paneForCreate.add(chk3,1,10);
                    paneForCreate.add(l9,0,11);
                    tf3.setText("");
                    paneForCreate.add(btFc, 1,11);
                    paneForCreate.add(btCreate,1,12);
                    errorlbl.setText("");
                    paneForCreate.add(errorlbl, 0,13);
                    l19.setText("");
                    paneForCreate.add(l19,0,14);
                    pane.getChildren().removeAll(welcomeText, paneForSelect, paneForUpdate, paneForDelete, paneForCreate);
                    pane.getChildren().add(paneForCreate);
                    btFc.setOnAction((ActionEvent e2) -> {
                       fc.setTitle("12th grade marks sheet upload");
                       tf3.setText(fc.showOpenDialog(stage).getName());
                    });
                    btCreate.setOnAction((ActionEvent e1) -> {
                        boolean isValid = validateForm();
                        if(isValid){
                            String gender = "";
                            if(rb1.isSelected()){
                                gender = rb1.getText();
                            }
                            else{
                                gender = rb2.getText();
                            }
                            String sports = "";
                            if(chk1.isSelected()){
                                sports += chk1.getText() + " ";
                            }
                            if(chk2.isSelected()){
                                sports += chk2.getText() + " ";
                            }
                            if(chk3.isSelected()){
                                sports += chk3.getText();
                            }

                            boolean rsCreate = false;
                            try {
                                rsCreate = Student.insertStudentRecord(tf1.getText(), pf.getText(), tf2.getText(), gender, Date.valueOf(dp.getValue()), ta.getText(), cb.getValue(), sports, tf3.getText());
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            if(rsCreate){
                                l19.setText("Record created successfully");
                                l19.setTextFill(Color.GREEN);
                            }
                            else{
                                l19.setText("Record not created successfully");
                                l19.setTextFill(Color.RED);
                            }
                        }
                    });
        });

        m2.setOnAction((ActionEvent e) -> {
            paneForUpdate.getChildren().clear();
            paneForUpdate.add(txtUpdate,0,0);
            paneForUpdate.add(l1,0,1);
            tf1.setText("");
            paneForUpdate.add(tf1,1,1);
            paneForUpdate.add(l2,0,2);
            pf.setText("");
            paneForUpdate.add(pf,1,2);
            paneForUpdate.add(btUpdate, 1, 3);
            l22.setText("");
            paneForUpdate.add(l22,0,4);
            pane.getChildren().removeAll(welcomeText, paneForCreate, paneForSelect, paneForDelete, paneForUpdate);
            pane.getChildren().add(paneForUpdate);
            btUpdate.setOnAction((ActionEvent e1) -> {
                boolean isValid = false;
                try {
                    isValid = Student.updateVerification(tf1.getText(), pf.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if(isValid){
                    paneForUpdate.add(l3,0,5);
                    tf2.setText("");
                    paneForUpdate.add(tf2,1,5);
                    paneForUpdate.add(l4,0,6);
                    if(rb1.isSelected()){
                        rb1.setSelected(false);
                    }else{
                        rb2.setSelected(false);
                    }
                    paneForUpdate.add(rb1,1,6);
                    paneForUpdate.add(rb2, 2,6);
                    paneForUpdate.add(l5,0,7);
                    dp.setValue(null);
                    paneForUpdate.add(dp,1,7);
                    paneForUpdate.add(l6,0,8);
                    ta.setText("");
                    paneForUpdate.add(sp,1,8);
                    paneForUpdate.add(l7,0,9);
                    cb.setValue("");
                    paneForUpdate.add(cb,1,9);
                    paneForUpdate.add(l8,0,10);
                    if(chk1.isSelected()){
                        chk1.setSelected(false);
                    }
                    if(chk2.isSelected()){
                        chk2.setSelected(false);
                    }
                    if(chk3.isSelected()){
                        chk3.setSelected(false);
                    }
                    paneForUpdate.add(chk1,1,10);
                    paneForUpdate.add(chk2,1,11);
                    paneForUpdate.add(chk3,1,12);
                    paneForUpdate.add(l9,0,13);
                    paneForUpdate.add(btFc, 1,13);
                    tf3.setText("");
                    paneForUpdate.add(btUpdate2,1,14);
                    errorlbl.setText("");
                    paneForUpdate.add(errorlbl,0,15);
                    l21.setText("");
                    paneForUpdate.add(l21,0,16);
                    btFc.setOnAction((ActionEvent e2) -> {
                        fc.setTitle("12th grade marks sheet upload");
                        tf3.setText(fc.showOpenDialog(stage).getName());
                    });
                    btUpdate2.setOnAction((ActionEvent e3) -> {
                        boolean isValid1 = validateForm();
                        if(isValid1){
                            String gender = "";
                            if(rb1.isSelected()){
                                gender = rb1.getText();
                            }
                            else{
                                gender = rb2.getText();
                            }
                            String sports = "";
                            if(chk1.isSelected()){
                                sports += chk1.getText() + " ";
                            }
                            if(chk2.isSelected()){
                                sports += chk2.getText() + " ";
                            }
                            if(chk3.isSelected()){
                                sports += chk3.getText();
                            }

                            boolean rsUpdate = false;
                            try {
                                rsUpdate = Student.updateStudentRecord(tf1.getText(), pf.getText(), tf2.getText(), gender, Date.valueOf(dp.getValue()), ta.getText(), cb.getValue(), sports, tf3.getText());
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            if(rsUpdate){
                                l21.setText("Record updated successfully");
                                l21.setTextFill(Color.GREEN);
                            }
                            else{
                                l21.setText("Record not updated successfully");
                                l21.setTextFill(Color.RED);
                            }
                        }
                    });

                }else{
                    l22.setText("No such record found");
                    l22.setTextFill(Color.RED);
                }
            });
        });

        m3.setOnAction((ActionEvent e) -> {
            paneForSelect.getChildren().clear();
            paneForSelect.add(txtSelect,0,0);
            paneForSelect.add(l1, 0,1);
            tf1.setText("");
            paneForSelect.add(tf1,1,1);
            paneForSelect.add(l2,0,2);
            pf.setText("");
            paneForSelect.add(pf,1,2);
            paneForSelect.add(btSelect, 1, 3);
            errorlbl.setText("");
            paneForSelect.add(errorlbl, 0, 4);
            paneForSelect.add(l3,0,5);
            l12.setText("");
            paneForSelect.add(l12, 1,5);
            paneForSelect.add(l4, 0, 6);
            l13.setText("");
            paneForSelect.add(l13, 1,6);
            paneForSelect.add(l5, 0,7);
            l14.setText("");
            paneForSelect.add(l14, 1, 7);
            paneForSelect.add(l6,0,8);
            l15.setText("");
            paneForSelect.add(l15,1,8);
            paneForSelect.add(l7, 0,9);
            l16.setText("");
            paneForSelect.add(l16,1,9);
            paneForSelect.add(l10, 0,10);
            l17.setText("");
            paneForSelect.add(l17, 1,10);
            paneForSelect.add(l11,0,11);
            l18.setText("");
            paneForSelect.add(l18, 1,11);
            pane.getChildren().removeAll(welcomeText, paneForCreate, paneForUpdate, paneForDelete, paneForSelect);
            pane.getChildren().add(paneForSelect);
            btSelect.setOnAction((ActionEvent e1) -> {
                boolean isValid = validateForm1();
                if(isValid){
                    String[] rsArray = new String[7];
                    try {
                        rsArray = Student.selectStudentRecord(tf1.getText(), pf.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    l12.setText(rsArray[0]);
                    l13.setText(rsArray[1]);
                    l14.setText(rsArray[2]);
                    l15.setText(rsArray[3]);
                    l16.setText(rsArray[4]);
                    l17.setText(rsArray[5]);
                    l18.setText(rsArray[6]);
                }
            });
        });

        m4.setOnAction((ActionEvent e) -> {
            paneForDelete.getChildren().clear();
            paneForDelete.add(txtDelete, 0,0);
            paneForDelete.add(l1, 0,1);
            tf1.setText("");
            paneForDelete.add(tf1,1,1);
            paneForDelete.add(l2,0,2);
            pf.setText("");
            paneForDelete.add(pf,1,2);
            paneForDelete.add(btDelete, 1, 3);
            errorlbl.setText("");
            paneForDelete.add(errorlbl, 0, 4);
            l20.setText("");
            paneForDelete.add(l20, 0,5);
            pane.getChildren().removeAll(welcomeText, paneForCreate, paneForUpdate, paneForSelect, paneForDelete);
            pane.getChildren().add(paneForDelete);
            btDelete.setOnAction((ActionEvent e1) -> {
                boolean isValid = validateForm1();
                if(isValid){
                    boolean rsDelete = false;
                    try {
                        rsDelete = Student.deleteStudentRecord(tf1.getText(), pf.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    if(rsDelete){
                        l20.setText("Record deleted successfully");
                        l20.setTextFill(Color.GREEN);
                    }
                    else{
                        l20.setText("Record not deleted successfully");
                        l20.setTextFill(Color.RED);
                    }
                }
            });
        });

        // Creating a scene and placing the pane in it
        Scene scene = new Scene(pane);
        stage.setTitle("Student Details Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    public boolean validateForm(){
        boolean proceed = true;
        if(tf1.getText().isEmpty() && proceed){
            errorlbl.setText("Please enter the Registration Number");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(pf.getText().isEmpty() && proceed){
            errorlbl.setText("Please enter the password");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(tf2.getText().isEmpty() && proceed){
            errorlbl.setText("Please enter the name");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(rb1.isSelected() == false && rb2.isSelected() == false && proceed){
            errorlbl.setText("Please select the gender");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(dp.getValue() == null && proceed){
            errorlbl.setText("Please provide your date of birth");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(ta.getText().isEmpty() && proceed){
            errorlbl.setText("Please enter the address");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(cb.getValue() == null && proceed){
            errorlbl.setText("Please select the branch");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(chk1.isSelected() == false && chk2.isSelected() == false && chk3.isSelected() == false && proceed){
            errorlbl.setText("Please register for minimum one sports facility");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(tf3.getText().isEmpty() && proceed){
            errorlbl.setText("Please upload your 12th grade marks sheet");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        return proceed;
    }

    public boolean validateForm1(){
        boolean proceed = true;
        if(tf1.getText().isEmpty() && proceed){
            errorlbl.setText("Please enter the Registration Number");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        else if(pf.getText().isEmpty() && proceed){
            errorlbl.setText("Please enter the password");
            errorlbl.setTextFill(Color.RED);
            proceed = false;
        }
        return proceed;
    }
}

class Student {
    public static boolean insertStudentRecord(String regNo, String pass, String name, String gender, Date dob, String address, String branch, String sports, String fileName) throws SQLException {
        DbmsConnection dbmsConnect = null;
        PreparedStatement stmt = null;
        Connection con = null;
        try {
            dbmsConnect = new DbmsConnection("jdbc:mysql://localhost:3306/university", "root", "mysqlroot2606");
            con = dbmsConnect.getConnection();
            String sql = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, regNo);
            stmt.setString(2, pass);
            stmt.setString(3, name);
            stmt.setString(4, gender);
            stmt.setDate(5, dob);
            stmt.setString(6, address);
            stmt.setString(7, branch);
            stmt.setString(8, sports);
            stmt.setString(9, fileName);
            int i = stmt.executeUpdate();
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            dbmsConnect.closeConnection(con, stmt);
        }
    }

    public static boolean updateVerification(String regNo, String pass) throws SQLException {
        ResultSet rs;
        DbmsConnection dbmsConnect = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            dbmsConnect = new DbmsConnection("jdbc:mysql://localhost:3306/university", "root", "mysqlroot2606");
            con = dbmsConnect.getConnection();
            String sql = "select * from student where regNo = ? and pass = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, regNo);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            dbmsConnect.closeConnection(con, stmt);
        }
    }

    public static boolean updateStudentRecord(String regNo, String pass, String name, String gender, Date dob, String address, String branch, String sports, String fileName) throws SQLException {
        DbmsConnection dbmsConnect = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            dbmsConnect = new DbmsConnection("jdbc:mysql://localhost:3306/university", "root", "mysqlroot2606");
            con = dbmsConnect.getConnection();
            String sql = "update student set pass = ?, name = ?, gender = ?, dob = ?, address = ?, branch = ?, sports = ?, fileName = ? where regNo = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pass);
            stmt.setString(2, name);
            stmt.setString(3, gender);
            stmt.setDate(4, dob);
            stmt.setString(5, address);
            stmt.setString(6, branch);
            stmt.setString(7, sports);
            stmt.setString(8, fileName);
            stmt.setString(9, regNo);
            int i = stmt.executeUpdate();
            if(i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            dbmsConnect.closeConnection(con, stmt);
        }
    }

    public static String[] selectStudentRecord(String regNo, String pass) throws SQLException {
        ResultSet rs;
        DbmsConnection dbmsConnect = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String[] rsArray = new String[7];
        try {
            dbmsConnect = new DbmsConnection("jdbc:mysql://localhost:3306/university", "root", "mysqlroot2606");
            con = dbmsConnect.getConnection();
            String sql = "select * from student where regNo = ? and pass = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, regNo);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Required record found");
                rsArray = new String[]{rs.getString(3), rs.getString(4), String.valueOf(rs.getDate(5)), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
            } else {
                System.out.println("No such record found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            dbmsConnect.closeConnection(con, stmt);
        }
        return rsArray;
    }

    public static boolean deleteStudentRecord(String regNo, String pass) throws SQLException {
        DbmsConnection dbmsConnect = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            dbmsConnect = new DbmsConnection("jdbc:mysql://localhost:3306/university", "root", "mysqlroot2606");
            con = dbmsConnect.getConnection();
            String sql = "delete from student where regNo = ? and pass = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, regNo);
            stmt.setString(2, pass);
            int i = stmt.executeUpdate();
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            dbmsConnect.closeConnection(con, stmt);
        }
    }
}

class DbmsConnection {
    String url;
    String username;
    String pass;

    public DbmsConnection(String url, String username, String pass){
        this.url = url;
        this.username = username;
        this.pass = pass;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, pass);
        System.out.println("Connection established successfully");
        return con;
    }

    public void closeConnection(Connection con, Statement stmt) throws SQLException {
        stmt.close();
        con.close();
        System.out.println("Connection closed");
    }
}
