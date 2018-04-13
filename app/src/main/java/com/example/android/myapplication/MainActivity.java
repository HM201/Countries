package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private String url = "https://restcountries.eu/rest/v2/name/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final CountryModel countryModel = new CountryModel("Egypt","EGP"
//                ,90000000,"egyptian","mamlaket El tawab2");


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = parent.getItemAtPosition(position).toString();
                CountryModel countryModel = new CountryAsyncTaskLoader(this,url + choice);
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

                //startApi request Function
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}
