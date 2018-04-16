package com.example.android.myapplication;

import android.app.Activity;

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
//        final TextView nameTextView = (TextView) findViewById(R.id.name);
//
//        nameTextView.post(new Runnable() {
//            @Override
//            public void run() {
//                nameTextView.setText(countryModel.getName());
//            }
//        });
//
//        final TextView currencyTextView = (TextView) findViewById(R.id.currency);
//        currencyTextView.post(new Runnable() {
//            @Override
//            public void run() {
//                currencyTextView.setText(countryModel.getCurrency());
//            }
//        });
//
//        final TextView populationTextView = (TextView) findViewById(R.id.population);
//        populationTextView.post(new Runnable() {
//            @Override
//            public void run() {
//                populationTextView.setText(Integer.toString(countryModel.getPopulation()));
//            }
//        });
//
//        final TextView languageTextView = (TextView) findViewById(R.id.language);
//        languageTextView.post(new Runnable() {
//            @Override
//            public void run() {
//                languageTextView.setText(countryModel.getLanguage());
//            }
//        });
//
//        final TextView capitalTextView = (TextView) findViewById(R.id.capital);
//        capitalTextView.post(new Runnable() {
//            @Override
//            public void run() {
//                capitalTextView.setText(countryModel.getCapital());
//            }
//        });
    }
}
