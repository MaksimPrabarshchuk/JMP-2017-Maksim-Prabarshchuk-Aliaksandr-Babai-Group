package com.github.alebabai.jmp2k17.solid.dip.bad;


public class GoogleWeatherDataSource {
    private final String weather;

    public GoogleWeatherDataSource(String weather) {
        this.weather = weather;
    }

    public String getData() {
        return String.format("Weather from Google server %s", weather);
    }
}
