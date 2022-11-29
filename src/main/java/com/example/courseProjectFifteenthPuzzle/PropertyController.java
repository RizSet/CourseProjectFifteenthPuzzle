package com.example.courseProjectFifteenthPuzzle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyController {

    @FXML
    private Button accept;

    @FXML
    private Button back;

    @FXML
    private TextField fieldX;

    @FXML
    private TextField fieldY;
    @FXML
    private Label textX;

    @FXML
    private Label textY;

    @FXML
    private Label message;

    @FXML
    void initialize() {
        textX.setText(String.valueOf(GameController.getX()));
        textY.setText(String.valueOf(GameController.getY()));
        accept.setOnAction(event -> {
            String x = fieldX.getText();
            String y = fieldY.getText();
            Pattern pattern = Pattern.compile("^\\d{1}$");
            Matcher matcher = pattern.matcher(x);
            if (matcher.find() && Integer.valueOf(x) >= 3 && Integer.valueOf(x) <= 9) {
                textX.setText(x);
                GameController.setX(Integer.valueOf(x));
            } else {
                message.setText("enter number from 3 to 9");
            }
            matcher = pattern.matcher(y);
            if (matcher.find() && Integer.valueOf(y) >= 3 && Integer.valueOf(y) <= 9) {
                textY.setText(y);
                GameController.setY(Integer.valueOf(y));
            } else {
                message.setText("you enter wrong value");
            }
        });
        new ButtonActionUtil().actionBackButton(back);
    }
}
