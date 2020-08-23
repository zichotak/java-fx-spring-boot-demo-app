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

    private static final int BUTTON_ROWS = 4;
    private static final int BUTTON_COLUMNS = 4;

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

        for (int row = 0; row < BUTTON_ROWS; row++) {
            for (int column = 0; column < BUTTON_COLUMNS; column++) {
                Button button = new Button(String.valueOf(3*row + column));
                button.setPrefSize(75,75);
                initButton(button);
                gridPane.add(button, column, row);
            }

        }
    }

    private void initButton(Button button) {
        button.setOnAction(actionEvent -> {
            LOGGER.info("Button number {} clicked", button.getText());
        });
    }

    public PropertyBinder getPropertyBinder() {
        return propertyBinder;
    }

    public void setPropertyBinder(PropertyBinder propertyBinder) {
        this.propertyBinder = propertyBinder;
    }
}
