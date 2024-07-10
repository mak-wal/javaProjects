package com.example.buttonandlabel.ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    String turnCounter = "X";
    //    String matrixOfIndexes[][] = new String[3][3];
//    ArrayList<String> listOfIndexes = new ArrayList<>();
    String[][] matrix = new String[3][3];

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        Label turnInfo = new Label("Turn " + turnCounter);
        Label endMessage = new Label("");

        HBox infoBox = new HBox();

        infoBox.getChildren().addAll(turnInfo, endMessage);

        GridPane gameBoard = new GridPane();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button newButton = new Button("");


                newButton.setOnAction(event -> {
                    if (newButton.getText().isEmpty()) {
                        newButton.setText(turnCounter);

                        if (checkIfWinner()) {
                            endMessage.setText("The winner is: " + turnCounter);
                        } else if (checkIfBoardFilled()) {
                            endMessage.setText("It's a draw!");
                        } else

                        if (turnCounter.equals("X")) {
                            turnCounter = "O";
                        } else {
                            turnCounter = "X";
                        }
                        turnInfo.setText("Turn " + turnCounter);
                    }

                });
                matrix[i][j]=newButton.getText();
                gameBoard.add(newButton, i, j);
                /*newButton.setOnMouseClicked(event -> {
                    if (newButton.getText().isEmpty()) {
                        newButton.setText(turnCounter);

                        if (checkIfWinner()) {
                            endMessage.setText("The winner is: " + turnCounter);
                        }

                        if (turnCounter.equals("X")) {
                            turnCounter = "O";
                        } else {
                            turnCounter = "X";
                        }
                        turnInfo.setText("Turn " + turnCounter);
                    }
                });*/

            }
        }
        layout.setTop(infoBox);
        layout.setCenter(gameBoard);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

    public boolean checkIfWinner() {

        if (!matrix[0][0].isEmpty() && matrix[0][0].equals(matrix[0][1]) && matrix[0][0].equals(matrix[0][2]))
            return true;

        if (!matrix[1][0].isEmpty() && matrix[1][0].equals(matrix[1][1]) && matrix[1][0].equals(matrix[1][2]))
            return true;
        if (!matrix[2][0].isEmpty() && matrix[2][0].equals(matrix[2][1]) && matrix[2][0].equals(matrix[2][2]))
            return true;
        if (!matrix[0][0].isEmpty() && matrix[0][0].equals(matrix[1][0]) && matrix[0][0].equals(matrix[2][0]))
            return true;
        if (!matrix[0][1].isEmpty() && matrix[0][1].equals(matrix[1][1]) && matrix[0][1].equals(matrix[2][1]))
            return true;
        if (!matrix[0][2].isEmpty() && matrix[0][2].equals(matrix[1][2]) && matrix[0][2].equals(matrix[2][2]))
            return true;


        if (!matrix[0][0].isEmpty() && matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2]))
            return true;
        if (!matrix[0][2].isEmpty() && matrix[0][2].equals(matrix[1][1]) && matrix[0][2].equals(matrix[2][0]))
            return true;

        return false;
    }

    public boolean checkIfBoardFilled() {
        for (int i=0;i<3;i++) {
            for (int j = 0;j<3;j++) {
                if (matrix[i][j].isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

}
