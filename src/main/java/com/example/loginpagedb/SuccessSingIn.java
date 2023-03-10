package com.example.loginpagedb;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SuccessSingIn {
    private static BorderPane borderPane = new BorderPane();
    private static Scene scene = new Scene(borderPane);
    private static Stage stage = new Stage();
    private static Label succLabel = new Label("Success!");


    public static void start() {
        scene.setFill(Color.GREENYELLOW);
        succLabel.setTextFill(Color.DARKGREEN);
        succLabel.setFont(new Font(null, 20));
        borderPane.setCenter(succLabel);
        borderPane.setPadding(new Insets(10));
        stage.setTitle("Success!");
        stage.setScene(scene);
        stage.setWidth(200);
        stage.setHeight(120);
        stage.setResizable(false);
        stage.show();
    }
}
