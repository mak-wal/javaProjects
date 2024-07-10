package com.example.buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage window) {

        NumberAxis x = new NumberAxis(1968, 2008, 4);
        NumberAxis y = new NumberAxis(0, 30, 5);

        x.setLabel("Year");
        y.setLabel("Percentage");

        Map<String, HashMap<Integer, Double>> input = new HashMap<>();
///*
//DRUGA WERSJA
//*/
//        try {
//            Files.lines(Paths.get("partiesdata.tsv")).forEach(
//                    line -> {
//                        String[] row = line.split("\t");
//                        String partyName = row[0];
//                        HashMap<Integer, Double> data = new HashMap<>();
//                        int year = 1968; // Start from the year 1968
//                        for (int i = 1; i < row.length; i++) {
//                            if (row[i].equals("-")) {
//                                data.put(year, 0.0);
//                            } else {
//                                data.put(year, Double.parseDouble(row[i]));
//                            }
//                            year += 4; // Increment year every 4 years
//                        }
//                        input.put(partyName, data);
//                    });
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
///*
//        TRZECIA WERSJA
//*/
//        try {
//            List<String> lines = Files.lines(Paths.get("partiesdata.tsv")).collect(Collectors.toList());
//            String[] firstRow = lines.get(0).split("\t");
//            List<Integer> years = List.of(firstRow).subList(1, firstRow.length).stream()
//                    .map(Integer::valueOf)
//                    .collect(Collectors.toList());
//
//            for (int i = 1; i < lines.size(); i++) {
//                String[] row = lines.get(i).split("\t");
//                String party = row[0];
//                HashMap<Integer, Double> data = new HashMap<>();
//                for (int j = 1; j < row.length; j++) {
//                    if (row[j].equals("-")) {
//                        data.put(years.get(j - 1), 0.0);
//                    } else {
//                        data.put(years.get(j - 1), Double.valueOf(row[j]));
//                    }
//                }
//                input.put(party, data);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"));
            String[] firstRow = scanner.nextLine().split("\t");
            ArrayList<Integer> years = new ArrayList<>();
            for (int i=1;i<firstRow.length;i++) {
                years.add(i-1, Integer.valueOf(firstRow[i]));
            }
            List<String> partiesNames = new ArrayList<>();
            while (scanner.hasNextLine()) {
               String[] row = scanner.nextLine().split("\t");

                partiesNames.add(row[0]);
                HashMap<Integer, Double> data = new HashMap<>();

               for (int i=1;i<row.length;i++) {
                   if (row[i].equals("-")) {
                       data.put(years.get(i),0.0);
                   } else
                   data.put(years.get(i-1), Double.valueOf(row[i]));
               }
                input.put(row[0], data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LineChart<Number, Number> lineChart = new LineChart<>(x, y);
        lineChart.setTitle("Relative support of the parties");
        input.keySet().stream().forEach(
                party -> {
                    XYChart.Series parties = new XYChart.Series<>();
                    parties.setName(party);

                    input.get(party).entrySet().stream().forEach(
                            pair -> {
                                parties.getData().add(new XYChart.Data<>(pair.getKey(), pair.getValue()));
                            }
                    );
                    lineChart.getData().add(parties);
                }
        );


        Scene view = new Scene(lineChart, 840, 450);
        window.setScene(view);
        window.show();
    }
}
