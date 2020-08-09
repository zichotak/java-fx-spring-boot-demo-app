package com.ozich.javafxspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.ozich.javafxspringboot.initialize.StageInitializer;

@Configuration
@PropertySource({"classpath:application-fxml.properties"})
public class ApplicationConfig {

    @Bean(name = "initializer")
    public StageInitializer stageInitializer() {
        return new StageInitializer();
    }
}
