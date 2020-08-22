package com.ozich.javafxspringboot.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

@Component
public class StringToDoublePropertyConverter implements Converter<String, DoubleProperty> {

    private final Logger LOGGER = LoggerFactory.getLogger(StringToDoublePropertyConverter.class);

    @Override
    public DoubleProperty convert(String source) {
        try {
            return new SimpleDoubleProperty(Double.parseDouble(source));
        } catch (NumberFormatException e) {
            LOGGER.error("Cannot parse SimpleDoubleProperty from string {}", source);
        }
        return null;
    }
}
