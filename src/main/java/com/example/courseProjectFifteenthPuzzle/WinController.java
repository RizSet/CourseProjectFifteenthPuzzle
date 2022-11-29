package com.example.courseProjectFifteenthPuzzle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class WinController {
    private static String amountStepsForWin;

    public static void setAmountStepsForWin(String amountStepsForWin) {
        WinController.amountStepsForWin = amountStepsForWin;
    }

    @FXML
    private Text amountSteps;
    @FXML
    private Button exit;

    @FXML
    private Button property;

    @FXML
    private Button restart;

    @FXML
    void initialize() {
        amountSteps.setText(amountStepsForWin);
        new ButtonActionUtil().actionGameButton(restart);
        new ButtonActionUtil().actionPropertyButton(property);
        new ButtonActionUtil().actionExitButton(exit);
    }
}
