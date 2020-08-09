package com.ozich.javafxspringboot.initialize;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.ozich.javafxspringboot.main.ChartApplication;


@Component
public class StageInitializer implements ApplicationListener<ChartApplication.StageReadyEvent> {

    @Value("${fxml.chart.resource}")
    private Resource chartResource;

    @Override
    public void onApplicationEvent(final ChartApplication.StageReadyEvent event) {
        try {
            Parent parent = new FXMLLoader(chartResource.getURL()).load();

            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 800, 600));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Url for chart not specified or corrupted.");
        }

    }
}
