package com.ozich.javafxspringboot.loader;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import javafx.fxml.FXMLLoader;

/**
 * Class that allows to load spring properties into java FX controllers.
 * The FXMLLoader.load(URL, ResourceBundle) method you are calling is a static method -
 * so it actually pays no attention to the FXMLLoader instance you instantiated,
 * and consequently ignores the controllerFactory which references your Spring bean factory.
 */
public class SpringFxmlLoader {

    @Value("${fxml.calculator.resource}")
    private Resource chartResource;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public Object load() {
        try {
            FXMLLoader loader = new FXMLLoader(chartResource.getURL());
            // Allows java fx to recognize spring beans
            loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));

            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Cannot load resource " + chartResource.getFilename());
        }
    }
}