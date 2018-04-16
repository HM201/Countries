package com.example.android.myapplication;

import java.util.Observable;

/**
 * Created by Hisham on 4/11/2018.
 */

public class CountryModel extends Observable {

    private String name;
    private String currency;
    private int population;
    private String language;
    private String capital;

    public CountryModel() {
    }

    public CountryModel(String name, String currency, int population, String language, String capital) {
        this.name = name;
        this.currency = currency;
        this.population = population;
        this.language = language;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
        setChanged();
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
        setChanged();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        setChanged();
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
        setChanged();
    }

    public boolean isEmpty() {
        if (name.isEmpty() == true)
            return false;
        return true;
    }

}
