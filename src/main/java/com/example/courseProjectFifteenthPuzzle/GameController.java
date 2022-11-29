package com.example.courseProjectFifteenthPuzzle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Random;

public class GameController {
    private static int k = 1;
    private static int x = 4;
    private static int y = 4;
    private static int emptyX = x - 1;
    private static int emptyY = y - 1;
    private static boolean correctOrder;
    private static Button[][] buttons;

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static void setX(int x) {
        GameController.x = x;
    }

    public static void setY(int y) {
        GameController.y = y;
    }

    @FXML
    private Text amountSteps;

    @FXML
    private Button exit;

    @FXML
    private GridPane gr;

    @FXML
    private Button pattern;

    @FXML
    private Button patternEmpty;

    @FXML
    private Button property;

    @FXML
    private Button restart;

    @FXML
    void initialize() {
        emptyX = x - 1;
        emptyY = y - 1;
        createButtons();
        shakeButtons();
        gr.setLayoutX((550 - y * 50) / 2);
        gr.setLayoutY((650 - x * 50) / 2 + 50);
        new ButtonActionUtil().actionGameButton(restart);
        new ButtonActionUtil().actionPropertyButton(property);
        new ButtonActionUtil().actionExitButton(exit);
    }

    private void checkOrder() {
        int correctButtonText = 1;
        correctOrder = true;
        for (int i = 0; i < x; i++) {
            if (!correctOrder) {
                break;
            }
            for (int j = 0; j < y; j++) {
                if (i == x - 1 && j == y - 1) {
                    break;
                } else if (buttons[i][j].getText() == "") {
                    correctOrder = false;
                    break;
                } else if (Integer.valueOf(buttons[i][j].getText()) == correctButtonText) {
                    correctButtonText++;
                } else {
                    correctOrder = false;
                    break;
                }
            }
        }
    }

    private void createButtons() {

        buttons = new Button[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setStyle(pattern.getStyle());
                buttons[i][j].setTextFill(pattern.getTextFill());
                buttons[i][j].setFont(pattern.getFont());
                buttons[i][j].setPrefWidth(50);
                buttons[i][j].setPrefHeight(50);
                buttons[i][j].setText(String.valueOf(k++));

                gr.add(buttons[i][j], j, i);
                int colum = i;
                int row = j;
                buttons[i][j].setOnAction(event -> {
                    if (colum + 1 != x && buttons[colum + 1][row].getText().equals("")) {
                        buttons[colum + 1][row].setText(buttons[colum][row].getText());
                        buttons[colum + 1][row].setStyle(pattern.getStyle());
                        buttons[colum][row].setText("");
                        buttons[colum][row].setStyle(patternEmpty.getStyle());
                        amountSteps.setText(String.valueOf(Integer.valueOf(amountSteps.getText()) + 1));
                        checkOrder();
                    } else if (colum - 1 != -1 && buttons[colum - 1][row].getText().equals("")) {
                        buttons[colum - 1][row].setText(buttons[colum][row].getText());
                        buttons[colum - 1][row].setStyle(pattern.getStyle());
                        buttons[colum][row].setText("");
                        buttons[colum][row].setStyle(patternEmpty.getStyle());
                        amountSteps.setText(String.valueOf(Integer.valueOf(amountSteps.getText()) + 1));
                        checkOrder();
                    } else if (row + 1 != y && buttons[colum][row + 1].getText().equals("")) {
                        buttons[colum][row + 1].setText(buttons[colum][row].getText());
                        buttons[colum][row + 1].setStyle(pattern.getStyle());
                        buttons[colum][row].setText("");
                        buttons[colum][row].setStyle(patternEmpty.getStyle());
                        amountSteps.setText(String.valueOf(Integer.valueOf(amountSteps.getText()) + 1));
                        checkOrder();
                    } else if (row - 1 != -1 && buttons[colum][row - 1].getText().equals("")) {
                        buttons[colum][row - 1].setText(buttons[colum][row].getText());
                        buttons[colum][row - 1].setStyle(pattern.getStyle());
                        buttons[colum][row].setText("");
                        buttons[colum][row].setStyle(patternEmpty.getStyle());
                        amountSteps.setText(String.valueOf(Integer.valueOf(amountSteps.getText()) + 1));
                        checkOrder();
                    }
                    if (correctOrder) {
                        WinController.setAmountStepsForWin(String.valueOf(amountSteps.getText()));
                        new ButtonActionUtil().winButton(buttons[colum][row]);
                    }
                });
            }
        }
        buttons[x - 1][y - 1].setText("");
    }

    private void shakeButtons() {
        Move p = Move.toLeft;
        for (int i = 0; i < x * y * 20; i++) {
            Move r = Move.values()[new Random().nextInt(4)];
            if (r.equals(Move.toDown) && (p.equals(Move.toUp) || p.equals(Move.toDown))) {
                continue;
            } else if (r.equals(Move.toUp) && (p.equals(Move.toUp) || p.equals(Move.toDown))) {
                continue;
            } else if (r.equals(Move.toRight) && (p.equals(Move.toRight) || p.equals(Move.toLeft))) {
                continue;
            } else if (r.equals(Move.toLeft) && (p.equals(Move.toRight) || p.equals(Move.toLeft))) {
                continue;
            }
            switch (r) {
                case toRight:
                    if (emptyX > 0) {
                        buttons[emptyX][emptyY].setText(buttons[emptyX - 1][emptyY].getText());
                        buttons[emptyX - 1][emptyY].setText("");
                        emptyX = emptyX - 1;
                        p = r;
                    }
                    continue;
                case toLeft:
                    if (emptyX < x - 1) {
                        buttons[emptyX][emptyY].setText(buttons[emptyX + 1][emptyY].getText());
                        buttons[emptyX + 1][emptyY].setText("");
                        emptyX = emptyX + 1;
                        p = r;
                    }
                    continue;
                case toUp:
                    if (emptyY > 0) {
                        buttons[emptyX][emptyY].setText(buttons[emptyX][emptyY - 1].getText());
                        buttons[emptyX][emptyY - 1].setText("");
                        emptyY = emptyY - 1;
                        p = r;
                    }
                    continue;
                case toDown:
                    if (emptyY < y - 1) {
                        buttons[emptyX][emptyY].setText(buttons[emptyX][emptyY + 1].getText());
                        buttons[emptyX][emptyY + 1].setText("");
                        emptyY = emptyY + 1;
                        p = r;
                    }
            }
        }
        buttons[emptyX][emptyY].setStyle(patternEmpty.getStyle());
    }
}
