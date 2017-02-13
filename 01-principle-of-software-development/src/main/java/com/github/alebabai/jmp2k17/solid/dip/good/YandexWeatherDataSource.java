package com.github.alebabai.jmp2k17.solid.dip.good;


public class YandexWeatherDataSource extends AbstractWeatherDataSource {

    public YandexWeatherDataSource(String weather) {
        super(weather);
    }

    @Override
    public String getData() {
        return String.format("Weather from Yandex server %s", weather);
    }
}
