package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) {
        GridPane componentGroupGrid = new GridPane();

        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(20);
        menu.setPadding(new Insets(20, 20, 20, 20));

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);

        StackPane jokeScreen = createComponent(new Label("What do you call a bear with no teeth?"));
        StackPane componentGroup = createComponent(new Label("A gummy bear."));
        StackPane componentGroup2 = createComponent(new Label("Jeśli nie rozumiesz toś głąb"));

        jokeButton.setOnAction((event) ->componentGroupGrid.add(jokeScreen,1,1));
        answerButton.setOnAction((event) ->componentGroupGrid.add(componentGroup,1,2));
        explanationButton.setOnAction((event) ->componentGroupGrid.add(componentGroup2,1,3));
        componentGroupGrid.add(menu,0,1);
        componentGroupGrid.add(jokeScreen,1,1);

        Scene layout = new Scene(componentGroupGrid);
        window.setTitle("Joke App");
        window.setScene(layout);
        window.show();
    }

    public StackPane createComponent(Label text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(400, 200);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(text);

        return layout;
    }
}

/*package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        menu.getChildren().addAll(jokeButton,answerButton,explanationButton);
        menu.setSpacing(20);
        menu.setPadding(new Insets(20,20,20,20));

        StackPane answerView = createView(new Label("A gummy bear."));
        answerButton.setOnAction(event -> {layout.setTop(answerView);});

        StackPane explanationView = createView(new Label("Jeśli nie rozumiesz toś głąb"));
        explanationButton.setOnAction(event -> {layout.setTop(explanationView);});

        StackPane jokeView = createView(new Label("What do you call a bear with no teeth?"));
        jokeButton.setOnAction(event -> layout.setTop(jokeView));

        layout.setTop(jokeView);
        layout.setCenter(menu);
        menu.setAlignment(Pos.CENTER);

        Scene startView = new Scene(layout);
        window.setTitle("Joke App");
        window.setScene(startView);
        window.show();
    }
    public StackPane createView(Label text) {
        StackPane layout = new StackPane();
        layout.getChildren().add(text);

layout.setAlignment(Pos.TOP_CENTER);
text.setAlignment(Pos.BOTTOM_LEFT);
        layout.setPrefSize(300, 200);
        return layout;
    }
}*/



//package com.example.buttonandlabel;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//public class JokeApplication extends Application {
//    public static void main (String[] args) {
//        launch(JokeApplication.class);
//    }
//    public void start(Stage window) {
//        BorderPane componentGroup = new BorderPane();
//
//        Button button1 = new Button("Joke");
//        Button button2 = new Button("Answer");
//        Button button3 = new Button("Explanation");
//
//        HBox menu = new HBox();
//        menu.getChildren().addAll(button1, button2, button3);
//        menu.setAlignment(Pos.CENTER);
//        menu.setSpacing(20);
//
//        StackPane layout1 = createLayout("czy wiesz że kurrrita?");
//        StackPane layout2 = createLayout("przecież wiesz!");
//        StackPane layout3 = createLayout("no bo przecież Karol powiedział tak w przedszkolu");
//
//        button1.setOnAction(event -> {
//            componentGroup.setTop(layout1);
//        });
//        button2.setOnAction(event -> {
//            componentGroup.setTop(layout2);
//        });
//        button3.setOnAction(event -> {
//            componentGroup.setTop(layout3);
//        });
//
//        componentGroup.setCenter(menu);
//        componentGroup.setTop(layout1);
//        componentGroup.setPrefSize(300,200);
//        componentGroup.setPadding(new Insets(20,20,20,20));
//
//        Scene view1 = new Scene(componentGroup);
//        window.setScene(view1);
//        window.show();
//    }
//    public StackPane createLayout (String string) {
//        StackPane layout = new StackPane();
//        Label label = new Label(string);
//        layout.getChildren().add(label);
//        layout.setAlignment(Pos.CENTER);
//        layout.setPrefSize(200,100);
//        return layout;
//    }
//}