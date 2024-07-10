package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;



public class ButtonAndTextFieldApplication extends Application{

        public static void main(String[] args) {
            System.out.println("Hello world!");
            launch(ButtonAndTextFieldApplication.class);
        }

        public void start(Stage window) {

            FlowPane componentGroup = new FlowPane();
            Scene scene = new Scene(componentGroup);

            Button button = new Button();
            TextField textField = new TextField();

            componentGroup.getChildren().add(button);
            componentGroup.getChildren().add(textField);

            window.setTitle("Mrau");
            window.setScene(scene);
            window.show();
        }

    }


