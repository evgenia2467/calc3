package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller<setText> {
    @FXML
    TextField resultField;

    private Double accumulator;
    private boolean isAccumulatorUpdated = false;
    private String chosenOperation;
    private Double memory = 5d;

    public void clickedOperation(ActionEvent actionEvent) {
        var operation = ((Button) actionEvent.getTarget()).getText();
        System.out.println("Choose operation " + operation);
        if (operation.equals("=") && this.chosenOperation != null) {
            var x = accumulator;
            var y = Double.parseDouble(resultField.getText());
            if (chosenOperation.equals("+")) {
                accumulator = x + y;
                resultField.setText(accumulator.toString());
            }
            if (chosenOperation.equals("-")) {
                accumulator = x - y;
                resultField.setText(accumulator.toString());
            }
            if (chosenOperation.equals("X")) {
                accumulator = x * y;
                resultField.setText(accumulator.toString());
            }
            if (chosenOperation.equals("/")) {
                accumulator = x / y;
                resultField.setText(accumulator.toString());
            }
        } else {
            this.chosenOperation = operation;
            if (this.accumulator == null) {
                this.accumulator = Double.parseDouble(resultField.getText());
                this.isAccumulatorUpdated = true;
            }
        }
    }

    public void clickedDigit(ActionEvent actionEvent) {
        var digit = ((Button) actionEvent.getTarget()).getText();
        System.out.println("press " + digit);
        if (isAccumulatorUpdated) {
            resultField.setText("");
            this.isAccumulatorUpdated = false;
        }
        resultField.setText(resultField.getText() + digit);
    }

    public void clickedMemory(ActionEvent actionEvent) {
        var memoryOperation = ((Button) actionEvent.getTarget()).getText();
        System.out.println("Memory operation " + memoryOperation);
        if (memoryOperation.equals("MR")) {
            this.resultField.setText(this.memory.toString());
        } else if (memoryOperation.equals("M+")) {
            if (!resultField.getText().isBlank()) {
                memory = memory + Double.parseDouble(resultField.getText());
            }
        } else if (memoryOperation.equals("M-")) {
            memory = memory - Double.parseDouble(resultField.getText());
        }
    }

        public void clickedClear (ActionEvent actionEvent) {
            this.resultField.setText("");
            accumulator = null;
            chosenOperation = null;


        }
    }
