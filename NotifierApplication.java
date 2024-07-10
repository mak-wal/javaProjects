package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) {

        /*VBox componentGroup = new VBox();*/
        Button button = new Button("Update");
        Label stringComponent = new Label();
        TextField textField = new TextField();

        button.setOnAction((event) ->
        {stringComponent.setText(textField.getText());});

        VBox componentGroup = new VBox();
        componentGroup.getChildren().addAll(textField,button,stringComponent);

        Scene layer = new Scene(componentGroup);

        window.setScene(layer);
        window.setTitle("Notifier");
        window.show();
    }
}
