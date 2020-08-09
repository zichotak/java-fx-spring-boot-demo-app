package com.ozich.javafxspringboot.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ChartController implements Initializable {

    @FXML
    private Button button1;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        initButton1();
    }

    private void initButton1() {
        button1.setText("Press me!");
        button1.setOnAction(actionEvent -> {
            System.out.println("Button 1 pressed");
        });
    }
}
