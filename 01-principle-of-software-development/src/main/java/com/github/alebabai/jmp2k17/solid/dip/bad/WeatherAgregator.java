package com.github.alebabai.jmp2k17.solid.dip.bad;

public class WeatherAgregator {

    private final YandexWeatherDataSource yandexDataSource;
    private final GoogleWeatherDataSource googleDataSource;

    public WeatherAgregator(YandexWeatherDataSource yandexDataSource, GoogleWeatherDataSource googleDataSource) {
        this.yandexDataSource = yandexDataSource;
        this.googleDataSource = googleDataSource;
    }

    public void printComposedData() {
        System.out.println(yandexDataSource.getData());
        System.out.println(googleDataSource.getData());
    }

}
