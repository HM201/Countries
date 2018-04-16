package com.example.android.myapplication;

import android.app.Activity;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Satellite on 4/16/2018.
 */

public class weatherObserver extends Activity implements Observer {

    private weatherModel weathermodel;

    @Override
    public void update(Observable o, Object arg) {

        weathermodel = (weatherModel) o;

        TextView temperature = findViewById(R.id.temp);
        temperature.setText(weathermodel.getTemperature());

        TextView windSpeed = findViewById(R.id.wind_speed);
        windSpeed.setText(weathermodel.getWindspeed());

        TextView windDirection = findViewById(R.id.wind_direction);
        windDirection.setText(weathermodel.getWindDirection());

        TextView windDesc = findViewById(R.id.weather_desc);
        windDesc.setText(weathermodel.getWeatherDesc());

    }
}