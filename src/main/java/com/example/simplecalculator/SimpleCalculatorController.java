package com.example.simplecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SimpleCalculatorController {

    @FXML
    private Button additionButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button divisionButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button equalButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button floatingPointButton;

    @FXML
    private Button fourButton;

    @FXML
    private TextField inputTextfield;

    @FXML
    private Button minusButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button zeroButton;

    private String inputString = "";
    private String operation = "";

    @FXML
    void additionButtonPressed(ActionEvent event) {
        if (!inputString.equals("") && !inputString.equals(".")){
            operation = "+";
            inputString += " " + ((Button) event.getSource()).getText() + " ";
            inputTextfield.setText(inputString);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        inputTextfield.clear();
        inputString = "";
    }

    @FXML
    void divisionButtonPressed(ActionEvent event) {
        if (!inputString.equals("") && !inputString.equals(".")){
            operation = "/";
            inputString += " " + ((Button) event.getSource()).getText() + " ";
            inputTextfield.setText(inputString);
        }
    }

    @FXML
    void eightButtonPressed(ActionEvent event) {
            inputString += ((Button) event.getSource()).getText();
            inputTextfield.setText(inputString);
    }

    @FXML
    void equalButtonPressed(ActionEvent event) {
        if (!inputString.equals("")){
            String result = calculate(inputString , operation);
            if (!result.equals(null)){
                inputTextfield.clear();
                inputTextfield.setText(result);
                operation = "";
                inputString = "";
            }
        }
    }

    void equalButtonPressed() {
        if (!inputString.equals("")){
            String result = calculate(inputString , operation);
            if (!result.equals(null)){
                inputTextfield.clear();
                inputTextfield.setText(result);
                operation = "";
                inputString = "";
            }
        }
    }

    @FXML
    void floatingPointButtonPressed(ActionEvent event) {
        if (!inputString.equals("")){
            inputString += ((Button) event.getSource()).getText();
            inputTextfield.setText(inputString);
        }
    }

    @FXML
    void minusButtonPressed(ActionEvent event) {
        if (!inputString.equals("") && !inputString.equals(".")){
            operation = "-";
            inputString += " " + ((Button) event.getSource()).getText() + " ";
            inputTextfield.setText(inputString);
        }
    }

    @FXML
    void multiplyButtonPressed(ActionEvent event) {
        if (!inputString.equals("") && !inputString.equals(".")){
            operation = "*";
            inputString += " " + ((Button) event.getSource()).getText() + " ";
            inputTextfield.setText(inputString);
        }
    }

    @FXML
    void nineButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void fourButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void fiveButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void oneButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void sevenButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }


    @FXML
    void sixButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void threeButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void twoButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void zeroButtonPressed(ActionEvent event) {
        inputString += ((Button) event.getSource()).getText();
        inputTextfield.setText(inputString);
    }

    @FXML
    void buttonKeyPressed(KeyEvent event) {
        switch (event.getCode()){
            case DIGIT0 -> inputString += "0";
            case DIGIT1 -> inputString += "1";
            case DIGIT2 -> inputString += "2";
            case DIGIT3 -> inputString += "3";
            case DIGIT4 -> inputString += "4";
            case DIGIT5 -> inputString += "5";
            case DIGIT6 -> inputString += "6";
            case DIGIT7 -> inputString += "7";
            case DIGIT8 -> inputString += "8";
            case DIGIT9 -> inputString += "9";
            case MINUS -> {
                if (!inputString.equals("") && !inputString.equals(".")){
                    inputString += " - ";
                    operation = "-";
                }
            }
            case SHIFT -> {
                if (!inputString.equals("") && !inputString.equals(".")){
                    inputString += " + ";
                    operation = "+";
                }
            }
            case SLASH -> {
                if (!inputString.equals("") && !inputString.equals(".")){
                    inputString += " / ";
                    operation = "/";
                }
            }
            case MULTIPLY -> {
                if (!inputString.equals("") && !inputString.equals(".")){
                    inputString += " * ";
                    operation = "*";
                }
            }
            case PERIOD -> {
                if (!inputString.equals("")){
                    inputString += ".";
                }
            }
            case ENTER -> equalButtonPressed();
            default -> System.out.println(event.getCode());
        }

    }

    String calculate(String inputString , String operation){
        if (operation.equals(""))
            return null;
        float resultNumber = 0;
        String num1 = inputString.split(" ") [0].trim();
        String num2 = inputString.split(" ") [2].trim();
        float number1 , number2;
        int type; //if numbers are integer --> 1        else --> 0
        if (num1.contains(".") || num2.contains(".")){
              number1 = Float.parseFloat(num1);
              number2 = Float.parseFloat(num2);
              type = 0;
        }
        else {
             number1 = Integer.parseInt(num1);
             number2 = Integer.parseInt(num2);
             type = 1;
        }
        switch (operation){
            case "+":
                resultNumber = number1 + number2;
                break;
            case "-":
                resultNumber = number1 - number2;
                break;
            case "*":
                resultNumber = number1 * number2;
                break;
            case "/":
                if ((type == 1 && number2 == 0) || (Math.signum(number2) == 0)){
                    return null;
                }
                resultNumber = number1 / number2;
                break;
        }
        String result = String.valueOf(resultNumber);
        if (type == 1){
            result = result.split("\\.") [0];
        }
        return result;
    }

}
