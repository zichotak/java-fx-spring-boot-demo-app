package com.ozich.javafxspringboot.converter;

import org.springframework.core.convert.converter.Converter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StringToStringPropertyConverter implements Converter<String, StringProperty> {
    @Override
    public StringProperty convert(String source) {
        return new SimpleStringProperty(source);
    }
}
