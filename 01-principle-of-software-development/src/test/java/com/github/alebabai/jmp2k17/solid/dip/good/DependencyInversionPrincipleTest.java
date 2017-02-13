package com.github.alebabai.jmp2k17.solid.dip.good;

import org.junit.Test;

public class DependencyInversionPrincipleTest {
    @Test
    public void goodExampleTest() {
        System.out.println("Run Good Example");
        final WeatherAgregator agregator = new WeatherAgregator(new YandexWeatherDataSource("+12 Celsius"), new GoogleWeatherDataSource("+11 Celsius"));
        agregator.printComposedData();
        System.out.println();
    }
}
