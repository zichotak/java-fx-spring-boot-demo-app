package com.ozich.javafxspringboot.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import com.ozich.javafxspringboot.binder.PropertyBinder;

public class CalculatorController implements Initializable {

    private final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    private static final int NUMERIC_BUTTON_ROWS = 3;
    private static final int NUMERIC_BUTTON_COLUMNS = 3;

    @Autowired
    private PropertyBinder propertyBinder;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField textField;

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        textField.layoutXProperty().unbind();
        textField.layoutYProperty().unbind();
        gridPane.layoutXProperty().unbind();
        gridPane.layoutYProperty().unbind();
        gridPane.setPadding(new Insets(propertyBinder.getGridPanePadding()));

        addButtons();
    }

    private void addButtons() {
        addNumericButtons();
        addOperatorButtons();
    }

    private void addNumericButtons() {
        for (int row = 0; row < NUMERIC_BUTTON_ROWS; row++) {
            int reversedRow = NUMERIC_BUTTON_ROWS - row;

            for (int column = 0; column < NUMERIC_BUTTON_COLUMNS; column++) {
                int reversedColumn = NUMERIC_BUTTON_COLUMNS - column;
                int buttonName = reversedRow*NUMERIC_BUTTON_COLUMNS - reversedColumn + 1;
                addSimplebutton(String.valueOf(buttonName), column, row);
            }
        }
        addSimplebutton("0", 1, 3);
    }

    private void addSimplebutton(String buttonName, int column, int row) {
        Button button = createButton(buttonName);
        initSimpleButton(button);
        gridPane.add(button, column, row);
    }

    private Button createButton(String buttonName) {
        Button button = new Button(buttonName);
        button.setPrefSize(propertyBinder.getButtonPrefWidth(),propertyBinder.getButtonPrefHeight());
        return button;
    }

    private void initSimpleButton(Button button) {
        button.setOnAction(actionEvent -> {
            LOGGER.info("Button number {} clicked", button.getText());
            textField.setText(textField.getText() + button.getText());
        });
    }


    private void addOperatorButtons() {
        addSimplebutton("/", 3, 0);
        addSimplebutton("*", 3, 1);
        addSimplebutton("-", 3, 2);
        addSimplebutton("+", 3, 3);
        addSimplebutton("+/-", 0, 3);
        addSimplebutton(".", 2, 3);
    }



    public PropertyBinder getPropertyBinder() {
        return propertyBinder;
    }

    public void setPropertyBinder(PropertyBinder propertyBinder) {
        this.propertyBinder = propertyBinder;
    }
}
