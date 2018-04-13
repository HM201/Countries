package com.example.android.myapplication;

/**
 * Created by Hisham on 4/11/2018.
 */

public class CountryModel {

    private String name;
    private String currency;
    private int population;
    private String language;
    private String capital;
    //add country observer and log and log factory.

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
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

}
