package com.github.alebabai.jmp2k17.solid.dip.good;

public abstract class AbstractWeatherDataSource implements DataSource<String > {

    protected final String weather;

    public AbstractWeatherDataSource(String weather) {
        this.weather = weather;
    }
}
