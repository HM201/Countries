package com.example.android.myapplication;

import android.app.Activity;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Hisham on 4/14/2018.
 */

public class CountryObserver extends Activity implements Observer {

    private CountryModel countryModel;

    @Override
    public void update(Observable o, Object arg) {

        countryModel = (CountryModel) o;

        TextView nameTextView = (TextView) findViewById(R.id.name);
        nameTextView.setText(countryModel.getName());

        TextView currencyTextView = (TextView) findViewById(R.id.currency);
        currencyTextView.setText(countryModel.getCurrency());

        TextView populationTextView = (TextView) findViewById(R.id.population);
        populationTextView.setText(Integer.toString(countryModel.getPopulation()));

        TextView languageTextView = (TextView) findViewById(R.id.language);
        languageTextView.setText(countryModel.getLanguage());

        TextView capitalTextView = (TextView) findViewById(R.id.capital);
        capitalTextView.setText(countryModel.getCapital());
    }
}
