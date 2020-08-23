package com.ozich.javafxspringboot.binder;

import org.springframework.beans.factory.annotation.Value;

/**
 *  Helper to bind properties from spring to fxml
 */
public class PropertyBinder {
    @Value("${fxml.calculator.textField.layoutX}")
    private double textFieldLayoutX;

    @Value("${fxml.calculator.textField.layoutY}")
    private double textFieldLayoutY;

    @Value("${fxml.calculator.textField.prefWidth}")
    private double textFieldPrefWidth;

    @Value("${fxml.calculator.textField.prefHeight}")
    private double textFieldPrefHeight;

    @Value("${fxml.calculator.gridPane.layoutX}")
    private double gridPaneLayoutX;

    @Value("${fxml.calculator.gridPane.layoutY}")
    private double gridPaneLayoutY;

    @Value("${fxml.calculator.gridPane.prefWidth}")
    private double gridPanePrefWidth;

    @Value("${fxml.calculator.gridPane.prefHeight}")
    private double gridPanePrefHeight;

    @Value("${fxml.calculator.gridPane.hgap}")
    private double gridPaneHgap;

    @Value("${fxml.calculator.gridPane.vgap}")
    private double gridPaneVGap;

    @Value("${fxml.calculator.gridPane.padding}")
    private double gridPanePadding;

    @Value("${fxml.calculator.button.prefWidth}")
    private double buttonPrefWidth;

    @Value("${fxml.calculator.button.prefHeight}")
    private double buttonPrefHeight;

    public double getTextFieldLayoutX() {
        return textFieldLayoutX;
    }

    public double getTextFieldLayoutY() {
        return textFieldLayoutY;
    }

    public double getTextFieldPrefWidth() {
        return textFieldPrefWidth;
    }

    public double getTextFieldPrefHeight() {
        return textFieldPrefHeight;
    }

    public double getGridPaneLayoutX() {
        return gridPaneLayoutX;
    }

    public double getGridPaneLayoutY() {
        return gridPaneLayoutY;
    }

    public double getGridPanePrefWidth() {
        return gridPanePrefWidth;
    }

    public double getGridPanePrefHeight() {
        return gridPanePrefHeight;
    }

    public double getGridPaneHgap() {
        return gridPaneHgap;
    }

    public double getGridPaneVGap() {
        return gridPaneVGap;
    }

    public double getGridPanePadding() {
        return gridPanePadding;
    }

    public double getButtonPrefWidth() {
        return buttonPrefWidth;
    }

    public double getButtonPrefHeight() {
        return buttonPrefHeight;
    }
}
