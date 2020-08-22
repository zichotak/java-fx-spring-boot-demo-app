package com.ozich.javafxspringboot.converter;

import org.junit.jupiter.api.Test;

import javafx.beans.property.DoubleProperty;

import static org.junit.jupiter.api.Assertions.*;

class StringToDoublePropertyConverterTest {

    @Test
    public void test() {
        StringToDoublePropertyConverter converter = new StringToDoublePropertyConverter();

        DoubleProperty property = converter.convert("55");

        assertEquals(55, property.get());
    }
}