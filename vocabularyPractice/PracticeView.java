package com.example.buttonandlabel.vocabularyPractice;

import com.example.buttonandlabel.vocabularyPractice.Dictionary;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PracticeView {

    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandom();
    }
    public Parent getView() {
        BorderPane layout = new BorderPane();

        Label instructionLine = new Label("Translate the word '" + this.word + "'");
        TextField answer = new TextField();
        Button checkButton = new Button("Check");
        Label solutionLabel = new Label("");

        VBox vbox = new VBox();

        vbox.getChildren().addAll(instructionLine, answer, checkButton, solutionLabel);

        layout.setCenter(vbox);

        checkButton./*setOnAction*/setOnMouseClicked(event -> {

            if (answer.getText().equals(dictionary.get(this.word))) {
                solutionLabel.setText("Correct!");
            } else {
                solutionLabel.setText("Incorrect!Correct would be: '" + dictionary.get(this.word)+"'.");
            return;
            }
            this.word = this.dictionary.getRandom();
            instructionLine.setText("Translate the word '" + this.word + "'");
            answer.clear();
        });
        return layout;
    }

}
