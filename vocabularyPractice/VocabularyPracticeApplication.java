package com.example.buttonandlabel.vocabularyPractice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void start(Stage window) throws Exception{
        BorderPane layout = new BorderPane();

        PracticeView practiceView = new PracticeView(dictionary);
        InputView inputView = new InputView(dictionary);

        Button enterNewWordButton = new Button("Enter new words");
        Button practiceButton = new Button("Go practice!");

        HBox menu = new HBox();
        menu.getChildren().addAll(enterNewWordButton,practiceButton);
        layout.setTop(menu);

        enterNewWordButton.setOnAction(event -> {
            layout.setCenter(inputView.getView());
        });
        practiceButton.setOnAction(event -> {
            layout.setCenter(practiceView.getView());
        });

        layout.setCenter(inputView.getView());

        Scene view = new Scene(layout,400,300);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }
}
