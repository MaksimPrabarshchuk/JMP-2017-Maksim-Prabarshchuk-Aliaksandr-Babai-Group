package com.github.alebabai.jmp2k17.solid.dip.good;

import java.util.Arrays;
import java.util.List;

public class WeatherAgregator {
    private List<DataSource<String>> dataSources;

    public WeatherAgregator(DataSource<String>... dataSources) {
        this.dataSources = Arrays.asList(dataSources);
    }

    public void printComposedData() {
        dataSources.stream()
                .map(DataSource::getData)
                .forEach(System.out::println);
    }

}
