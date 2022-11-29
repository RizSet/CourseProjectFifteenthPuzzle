package com.example.courseProjectFifteenthPuzzle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController extends Application {

    @FXML
    private Button exit;

    @FXML
    private Button game;

    @FXML
    private Button property;

    @FXML
    void initialize() {
        new ButtonActionUtil().actionGameButton(game);
        new ButtonActionUtil().actionPropertyButton(property);
        new ButtonActionUtil().actionExitButton(exit);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(StartController.class.getResource("startWindow.fxml"));
//        StartController.class.getResource("\\com\\example\\courseProjectFifteenthPuzzles\\startWindow.fxml")
        Scene scene = new Scene(fxmlLoader.load(), 250, 250);
        stage.setTitle("Fifteenth Puzzles");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

