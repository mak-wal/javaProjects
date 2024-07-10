package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.security.auth.callback.LanguageCallback;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) {
        BorderPane componentGroup = new BorderPane();
        componentGroup.setPadding(new Insets(20, 50, 20, 50));
        componentGroup.setPrefSize(580, 640);

        NumberAxis x = new NumberAxis(0, 30, 1);
        NumberAxis y = new NumberAxis();                //must adapt

        LineChart<Number, Number> lineChart = new LineChart<>(x, y);
        lineChart.setTitle("Oszczędności w skali roku");
//        lineChart.setLegendVisible(false);

        componentGroup.setCenter(lineChart);

        VBox slidersPane = new VBox();
        slidersPane.setSpacing(25);

        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);

        Slider interestSlider = new Slider(0, 10, 10);
        savingsSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);

        BorderPane savingsPane = new BorderPane();
        Label text = new Label("Monthly savings");
        Label valueText = new Label(String.valueOf(savingsSlider.getValue()));

        XYChart.Series dataCollection = new XYChart.Series();
        savingsSlider.valueProperty().addListener((observable,newValue,oldValue)-> {
            dataCollection.getData().clear();
            valueText.setText(String.valueOf(newValue.doubleValue()));

            for (int i = 0; i <= x.getUpperBound(); i++) {
                dataCollection.getData().add(new XYChart.Data(i, i * 12 * Double.valueOf(valueText.getText())));
            }
        });

        savingsPane.setLeft(text);
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(valueText);

        BorderPane interestPane = new BorderPane();
        Label text2 = new Label("Yearly interest rate");

        XYChart.Series dataCollection2 = new XYChart.Series();
        Label valueText2 = new Label(String.valueOf(interestSlider.getValue()));
        interestSlider.valueProperty().addListener((observable,newValue,oldValue) -> {
            dataCollection2.getData().clear();
               valueText2.setText(String.valueOf(newValue.intValue()));
            for (int i = 0; i <= x.getUpperBound(); i++) {
                double value = i * 12 * Double.valueOf(valueText.getText());
                value *= (1+0.05*12);
                dataCollection2.getData().add(new XYChart.Data(i,value));
            }

        });

        interestPane.setLeft(text2);
        interestPane.setCenter(interestSlider);
        interestPane.setRight(valueText2);

        slidersPane.getChildren().addAll(savingsPane, interestPane);

        componentGroup.setTop(slidersPane);

        lineChart.getData().addAll(dataCollection,dataCollection2);
        Scene view = new Scene(componentGroup);
        window.setScene(view);
        window.setTitle("Oszczędności");
        window.show();
    }
}
