package com.ozich.javafxspringboot.initialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.ozich.javafxspringboot.events.StageReadyEvent;
import com.ozich.javafxspringboot.loader.SpringFxmlLoader;

public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("${fxml.calculator.window.width}")
    private double stageWidth;

    @Value("${fxml.calculator.window.height}")
    private double stageHeight;

    @Autowired
    SpringFxmlLoader springFxmlLoader;

    @Override
    public void onApplicationEvent(final StageReadyEvent event) {
            Parent parent = (Parent)springFxmlLoader.load();

            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, stageWidth, stageHeight));
            stage.show();
    }
}
