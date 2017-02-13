package com.github.alebabai.jmp2k17.solid.dip.good;


public class GoogleWeatherDataSource extends AbstractWeatherDataSource {

    public GoogleWeatherDataSource(String weather) {
        super(weather);
    }

    @Override
    public String getData() {
        return String.format("Weather from Google server %s", weather);
    }
}
