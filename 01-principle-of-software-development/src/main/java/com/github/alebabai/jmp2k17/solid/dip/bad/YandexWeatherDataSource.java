package com.github.alebabai.jmp2k17.solid.dip.bad;



public class YandexWeatherDataSource {

    private final String weather;

    public YandexWeatherDataSource(String weather) {
        this.weather = weather;
    }

    public String getData() {
        return String.format("Weather from Yandex server %s", weather);
    }
}
