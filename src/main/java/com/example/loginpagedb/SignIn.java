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

public class SignIn {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String FIND_USER = "SELECT COUNT(*) FROM user WHERE email = ? AND password = ?";

    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root);
    private static Stage stage = new Stage();
    private static VBox mainBox = new VBox();
    private static VBox emailBox = new VBox();
    private static VBox passwordBox = new VBox();
    private static Label emailLabel = new Label("Email");
    private static Label passwordLabel = new Label("Password");
    private static TextField emailTextField = new TextField();
    private static PasswordField passwordField = new PasswordField();
    private static Button signInButt = new Button("Sign In");


    public static void start() {
        mainBox.getChildren().addAll(emailBox, passwordBox);
        mainBox.setSpacing(20);
        emailBox.getChildren().addAll(emailLabel, emailTextField);
        emailBox.setSpacing(5);
        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        passwordBox.setSpacing(5);

        signInButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement();
                     PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER)) {  //poster='" + poster + "'");

                    //ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM user WHERE email ='" + emailTextField.getText() + "' AND password ='" + passwordField.getText() + "'");
                    preparedStatement.setString(1, emailTextField.getText());
                    preparedStatement.setString(2, passwordField.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int res = resultSet.getInt(1);
                        if (res != 1) {
                            CatchError.errorMessage("Wrong email or password!");
                        } else {
                            SuccessSingIn.start();
                        }
                    }
                } catch (SQLException e) {
                    CatchError.errorMessage(e.getMessage());
                }
            }
        });


        root.setCenter(mainBox);
        root.setBottom(signInButt);
        root.setPadding(new Insets(50));
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.setWidth(350);
        stage.setHeight(300);
        stage.setResizable(false);
        stage.show();
    }


}