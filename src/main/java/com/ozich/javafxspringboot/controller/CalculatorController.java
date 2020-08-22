package com.ozich.javafxspringboot.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CalculatorController implements Initializable {

    @Value("${fxml.calculator.button.layoutX}")
    DoubleProperty layoutX;

    @Value("${fxml.calculator.button.layoutY}")
    DoubleProperty layoutY;

    @Value("${fxml.calculator.button.prefWidth}")
    DoubleProperty prefWidth;

    @Value("${fxml.calculator.button.prefHeight}")
    DoubleProperty prefHeight;

    @Value("${fxml.calculator.window.height}")
    double windowHeight;

    @Value("${fxml.calculator.window.width}")
    double windowWidth;

    @Value("${fxml.calculator.button1.label}")
    StringProperty string;

    @FXML
    private Button button1;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        button1.layoutYProperty().unbind();
        button1.layoutXProperty().unbind();
        System.out.println("X class  " + layoutX);
        System.out.println("X button " + button1.layoutXProperty());
        System.out.println("Y class  " + layoutY);
        System.out.println("Y button " + button1.layoutYProperty());
        System.out.println();

        initButton1();
    }

    private void initButton1() {
        button1.setOnAction(actionEvent -> {

            button1.layoutYProperty().bind(layoutYProperty());
            button1.layoutXProperty().bind(layoutXProperty());

            if (layoutX.get() < (windowWidth - prefWidth.get())) {
                layoutX.setValue(layoutX.get() + prefWidth.get());
            } else {
                layoutX.setValue(0);
            }

            if (layoutY.get() < (windowHeight - prefHeight.get())) {
                layoutY.setValue(layoutY.get() + prefHeight.get());
            } else {
                layoutY.setValue(0);
            }

            button1.layoutYProperty().unbind();
            button1.layoutXProperty().unbind();

            System.out.println("Button 1 pressed");
            System.out.println("X class  " + layoutX);
            System.out.println("X button " + button1.layoutXProperty());
            System.out.println("Y class  " + layoutY);
            System.out.println("Y button " + button1.layoutYProperty());
            System.out.println();

        });
    }

    public double getLayoutX() {
        return layoutX.get();
    }

    public DoubleProperty layoutXProperty() {
        return layoutX;
    }

    public double getLayoutY() {
        return layoutY.get();
    }

    public DoubleProperty layoutYProperty() {
        return layoutY;
    }

    public double getPrefWidth() {
        return prefWidth.get();
    }

    public DoubleProperty prefWidthProperty() {
        return prefWidth;
    }

    public double getPrefHeight() {
        return prefHeight.get();
    }

    public DoubleProperty prefHeightProperty() {
        return prefHeight;
    }

    public String getString() {
        return string.get();
    }

    public StringProperty stringProperty() {
        return string;
    }
}
