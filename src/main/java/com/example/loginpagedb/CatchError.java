package com.example.loginpagedb;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CatchError {
    private static BorderPane borderPane = new BorderPane();
    private static Scene scene = new Scene(borderPane);
    private static Stage stage = new Stage();
    private static Label errorLabel = new Label();


    public static void start() {
        scene.setFill(Color.TOMATO);
        errorLabel.setTextFill(Color.TOMATO);
        errorLabel.setFont(new Font(null, 15));
        borderPane.setCenter(errorLabel);
        borderPane.setPadding(new Insets(10));
        stage.setTitle("Error!");
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(120);
        stage.setResizable(false);
        stage.show();
    }


    public static void errorMessage(String message) {
        errorLabel.setText(message);
        CatchError.start();
    }
}
