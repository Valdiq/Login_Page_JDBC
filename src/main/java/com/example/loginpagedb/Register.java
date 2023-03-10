package com.example.loginpagedb;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class Register {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String INSERT_VALUES = "INSERT INTO user VALUES (?,?,?,?)";
    private static int getCountOfRecords = 0;


    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root);
    private static Stage stage = new Stage();
    private static VBox mainBox = new VBox();
    private static VBox usernameBox = new VBox();
    private static VBox emailBox = new VBox();
    private static VBox passwordBox = new VBox();
    private static Label usernameLabel = new Label("Username");
    private static Label emailLabel = new Label("Email");
    private static Label passwordLabel = new Label("Password");
    private static TextField usernameTextField = new TextField();
    private static TextField emailTextField = new TextField();
    private static PasswordField passwordField = new PasswordField();
    private static Button registerButt = new Button("Register");


    public static void start() {

        mainBox.getChildren().addAll(usernameBox, emailBox, passwordBox);
        mainBox.setSpacing(20);
        mainBox.setPadding(new Insets(0, 0, 10, 0));
        usernameBox.getChildren().addAll(usernameLabel, usernameTextField);
        usernameBox.setSpacing(5);
        emailBox.getChildren().addAll(emailLabel, emailTextField);
        emailBox.setSpacing(5);
        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        passwordBox.setSpacing(5);


        registerButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement();
                     PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VALUES);) {

                    if (emailTextField.getText().matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b")) { //regEx Email

                        User user = new User(usernameTextField.getText(), emailTextField.getText(), passwordField.getText());
                        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM user");
                        while (resultSet.next()) {
                            getCountOfRecords = resultSet.getInt(1);
                        }
                        preparedStatement.setInt(1, getCountOfRecords + 2);
                        preparedStatement.setString(2, user.getUsername());
                        preparedStatement.setString(3, user.getEmail());
                        preparedStatement.setString(4, user.getPassword());
                        preparedStatement.executeUpdate();
                    } else {
                        CatchError.errorMessage("Invalid email!");
                    }
                } catch (SQLException e) {

                    CatchError.errorMessage(e.getMessage());
                }
            }
        });


        root.setCenter(mainBox);
        root.setBottom(registerButt);
        root.setPadding(new Insets(30, 50, 30, 50));
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.setWidth(350);
        stage.setHeight(300);
        stage.setResizable(false);
        stage.show();
    }
}
