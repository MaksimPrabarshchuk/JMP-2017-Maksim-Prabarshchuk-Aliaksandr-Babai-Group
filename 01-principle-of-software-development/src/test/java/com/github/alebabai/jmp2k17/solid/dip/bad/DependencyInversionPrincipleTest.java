package com.github.alebabai.jmp2k17.solid.dip.bad;

import org.junit.Test;

public class DependencyInversionPrincipleTest {
    @Test
    public void badExampleTest() {
        System.out.println("Run Bad Example");
        final WeatherAgregator agregator = new WeatherAgregator(new YandexWeatherDataSource("+12 Celsius"), new GoogleWeatherDataSource("+11 Celsius"));
        agregator.printComposedData();
        System.out.println();
    }
}
