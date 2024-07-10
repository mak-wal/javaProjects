package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane componentGroup = new BorderPane();
        VBox vbox = new VBox();
        GridPane gridPane = new GridPane();

        Label text = new Label("First view!");
        Button button = new Button("To the second view!");
        Button button2 = new Button("To the third view!");
        Label label2 = new Label("Second view!");
        Label label3 = new Label("Third view!");
        Button button3 = new Button("To the first view!");

        componentGroup.setCenter(button);
        componentGroup.setTop(text);
        vbox.getChildren().addAll(button2,label2);

        gridPane.add(label3,0,0);
        gridPane.add(button3,1,1);

        Scene layout = new Scene(componentGroup);
        Scene layout2 = new Scene(vbox);
        Scene layout3 = new Scene(gridPane);

        button.setOnAction(event ->
                stage.setScene(layout2));

        button2.setOnAction(event ->
                stage.setScene(layout3));

        button3.setOnAction(event ->
                stage.setScene(layout));



        stage.setTitle("Nowiutki Program");
        stage.setScene(layout);
        stage.show();

    }
}














