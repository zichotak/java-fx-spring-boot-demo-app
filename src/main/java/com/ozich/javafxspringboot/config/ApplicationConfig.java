package com.ozich.javafxspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import com.ozich.javafxspringboot.controller.CalculatorController;
import com.ozich.javafxspringboot.converter.StringToDoublePropertyConverter;
import com.ozich.javafxspringboot.converter.StringToStringPropertyConverter;
import com.ozich.javafxspringboot.initialize.StageInitializer;
import com.ozich.javafxspringboot.loader.SpringFxmlLoader;

@Configuration
@PropertySource({"classpath:application-fxml.properties"})
public class ApplicationConfig {

    @Bean(name = "initializer")
    public StageInitializer stageInitializer() {
        return new StageInitializer();
    }

    @Bean(name = "calculationController")
    public CalculatorController calculatorController() {
        return new CalculatorController();
    }

    @Bean(name = "springFxmlLoader")
    public SpringFxmlLoader springFxmlLoader() {
        return new SpringFxmlLoader();
    }

    @Bean(name = "stringToSimpleDoublePropertyConverter")
    public StringToDoublePropertyConverter stringToSimpleDoublePropertyConverter() {
        return new StringToDoublePropertyConverter();
    }

    @Bean(name = "stringToStringPropertyConverter")
    public StringToStringPropertyConverter stringToStringPropertyConverter() {
        return new StringToStringPropertyConverter();
    }

    // Register custom converters
    @Bean(name = "conversionService")
    public ConversionService conversionService() {
        GenericConversionService conversionService = new GenericConversionService();
        conversionService.addConverter(stringToSimpleDoublePropertyConverter());
        conversionService.addConverter(stringToStringPropertyConverter());
        return conversionService;
    }
}
