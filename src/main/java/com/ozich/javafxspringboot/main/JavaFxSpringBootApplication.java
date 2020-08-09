package com.ozich.javafxspringboot.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class JavaFxSpringBootApplication {
    public static void main(String[] args) {
        Application.launch(ChartApplication.class, args);
    }
}
