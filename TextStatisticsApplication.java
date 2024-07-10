package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout);


        layout.setCenter(new TextArea());
        layout.setBottom(new HBox(new Label("Letters: 0"),new Label("Words: 0"),new Label("The Longest word is:")));
/*
        layout.getChildren().add()
*/


        window.setScene(scene);
        window.setTitle("Text Statistics - Application.exe");
        window.show();
    }
}



