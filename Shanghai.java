package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Shanghai extends Application {

    public static void main(String[] args) {
        launch(Shanghai.class);
    }

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> ShanghaiRanks = new LineChart<>(xAxis, yAxis);
        ShanghaiRanks.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series Helsinki = new XYChart.Series();

        try (Scanner scanner = new Scanner(Paths.get("Shanghai.txt"))) {
            while (scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().split(" ");

                Helsinki.getData().add(new XYChart.Data(Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*try {
            Files.lines(Paths.get("Shanghai.txt")).forEach(
                    row -> {
                        String[] numbers = row.split(" ");

                        Helsinki.getData().add(new XYChart.Data(Integer.valueOf(numbers[0]),Integer.valueOf(numbers[1])));
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        ShanghaiRanks.getData().add(Helsinki);
        Scene scene = new Scene(ShanghaiRanks, 640, 480);
        window.setScene(scene);
        window.show();
    }
}
