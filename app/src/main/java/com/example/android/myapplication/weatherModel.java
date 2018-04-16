package com.example.android.myapplication;

import java.util.Observable;

/**
 * Created by Satellite on 4/16/2018.
 */

public class weatherModel extends Observable {

    String temperature;
    String weatherDesc;
    String windspeed;
    String windDirection;

    weatherModel() {
    }

    weatherModel(String temperature, String weatherDesc, String windspeed, String windDirection) {
        this.temperature = temperature;
        this.weatherDesc = weatherDesc;
        this.windDirection = windDirection;
        this.windspeed = windspeed;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
        setChanged();
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
        setChanged();
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
        setChanged();
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
        setChanged();
    }


}
