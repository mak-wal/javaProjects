package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication2 extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication2.class);
    }

    @Override
    public void start(Stage window) {

        TextArea textField = new TextArea("");
        Label letters = new Label(
                /*"Letters:"*/
        );
        Label words = new Label(
                /*"Words:"*/
        );
        Label longestWord = new Label(
                /*"The longest word:"*/
        );

        BorderPane componentGroup = new BorderPane();
        HBox hBox = new HBox();
        hBox.setSpacing(20);

        /*hBox.getChildren().add(letters);
        hBox.getChildren().add(words);
        hBox.getChildren().add(longestWord);*/
        hBox.getChildren().addAll(letters, words, longestWord);
        /*componentGroup.getChildren().addAll(textField, hBox);*/
        textField.textProperty().addListener((change,oldValue,newValue)->{

            int howManyLetters = newValue.length();
            String[] parts = newValue.split(" ");
            int howManyWords = parts.length;

            String longest = Arrays.stream(parts)
                    .sorted((word1,word2)->word2.length()-word1.length())
                    .findFirst()
                    .get();

            letters.setText("Letters: " + howManyLetters);
            words.setText("Words: " + howManyWords);
            longestWord.setText("The longest word is: " + longest);
        });

        componentGroup.setCenter(textField);
        componentGroup.setBottom(hBox);
        Scene scene = new Scene(componentGroup);

        window.setScene(scene);
        window.setTitle("Statistics");

        window.show();
    }
}