
package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) {
        GridPane componentGroup = new GridPane();
        BorderPane componentGroup2 = new BorderPane();
        Label text = new Label("Enter your nick/login");
        TextField textField = new TextField();
        Button button = new Button("Log in");
        Label text2 = new Label();


//*
///textField.textProperty().addListener((change, newValue, oldValue) ->
                //{text2.setText("Welcome " + newValue + "!");} );


        Scene greetingLayout = new Scene(componentGroup2);

        button.setOnAction(event -> {
                    text2.setText("Welcome " + textField.getText().trim() + "!");

                    stage.setScene(greetingLayout);
                }
        );
        componentGroup2.setPrefSize(150,150);
        componentGroup2.setCenter(text2);

        componentGroup.add(text, 1, 1);
        componentGroup.add(textField, 1, 2);
        componentGroup.add(button, 1, 3);

        componentGroup.setPrefSize(180,300);
        //componentGroup.setHgap(20);
        componentGroup.setVgap(5);
        componentGroup.setPadding(new Insets(20,20,20,20));
        componentGroup.setAlignment(Pos.CENTER);

        Scene startLayout = new Scene(componentGroup);


        stage.setScene(startLayout);
        stage.show();
    }
}

/*package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class GreeterApplication extends Application{

        public static void main (String[] args) {
                launch(GreeterApplication.class);
        }

        public void start(Stage window) {
                BorderPane layout = new BorderPane();
                Label greeting = new Label("Enter your login:");
                TextField loginField = new TextField();
                Button button = new Button("Log in");

                VBox componentGroup = new VBox();
                componentGroup.getChildren().addAll(greeting,loginField,button);

                *//*componentGroup.setPrefSize(300,400);*//*
                componentGroup.setAlignment(Pos.CENTER);
                componentGroup.setSpacing(20);

*//*
                //layout.getChildren().add(componentGroup);
*//*
                layout.setCenter(componentGroup);
                layout.setPrefSize(300,400);
                layout.setPadding(new Insets(20,20,20,20));


                BorderPane greetingLayout = new BorderPane();

                String input = loginField.getText().trim();
                button.setOnAction(event -> {
                        greetingLayout.setCenter(new Label("Welcome " + input));
                        window.setScene(new Scene(greetingLayout));

                });
               // *//*greetingLayout.getChildren().add(new Label("Welcome " + input));*//*
                Scene view = new Scene(layout);
                window.setScene(view);
                window.show();
        }

}*/

