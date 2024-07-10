package com.example.buttonandlabel.vocabularyPractice;

import com.example.buttonandlabel.vocabularyPractice.Dictionary;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class InputView {

    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = new Dictionary();
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();

        //Button dictionaryButton = new Button("Enter new words");
        //Button practiceButton = new Button("Add the word pair");
        Button addButton = new Button("Add the word Pair");
        Label label1 = new Label("Word");
        Label label2 = new Label("Translation");
        TextField newWordField = new TextField();
        TextField translationField = new TextField();

        layout.setPrefSize(400, 400);
        HBox hBox = new HBox();
        VBox vBox = new VBox();

        //hBox.getChildren().addAll(dictionaryButton, practiceButton);
        vBox.getChildren().addAll(label1, newWordField, label2, translationField, addButton);

        layout.setCenter(vBox);
        layout.setTop(hBox);
        addButton./*setOnAction*/setOnMouseClicked(event -> {
            dictionary.add(newWordField.getText(), translationField.getText());
            newWordField.clear();
            translationField.clear();
        });

        return layout;
    }
}
