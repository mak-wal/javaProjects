package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage window) {
        BorderPane componentGroup = new BorderPane();
        Canvas canvas = new Canvas(640, 480);

        componentGroup.setCenter(canvas);
        GraphicsContext drawing = canvas.getGraphicsContext2D();

        drawing.setFill(Color.BLUE);
        drawing.fillRect(200,300,300,52);

        drawing.setFill(Color.BLACK);
        drawing.fillOval(200, 100, 25, 5);
        drawing.fillOval(440, 100, 25, 5);


        Scene scene = new Scene(componentGroup);
        window.setScene(scene);
        window.show();
    }
}

