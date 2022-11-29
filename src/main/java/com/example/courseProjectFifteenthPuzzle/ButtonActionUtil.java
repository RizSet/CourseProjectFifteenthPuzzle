package com.example.courseProjectFifteenthPuzzle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonActionUtil {
    public void actionGameButton(Button button) {
        button.setOnAction(event -> {
            button.getScene().getWindow().hide();
            newWindowLoader("gameWindow.fxml");
        });
    }

    public void actionPropertyButton(Button button) {
        button.setOnAction(event -> {
            button.getScene().getWindow().hide();
            newWindowLoader("propertyWindow.fxml");
        });
    }

    public void actionExitButton(Button button) {
        button.setOnAction(event -> {
            System.exit(0);
        });
    }
    public void actionBackButton(Button button) {
        button.setOnAction(event -> {
            button.getScene().getWindow().hide();
            newWindowLoader("startWindow.fxml");
        });
    }

    public void winButton(Button button) {

        button.getScene().getWindow().hide();
        newWindowLoader("winWindow.fxml");

    }



    private void newWindowLoader(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Fifteenth Puzzles");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}


