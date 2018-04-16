package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener, LoaderManager.LoaderCallbacks<CountryModel>*/ {

    //    private final MainActivity self = this;
//    public CountryObserver countryObserver;
//    private String URL = "https://restcountries.eu/rest/v2/name/";
//    private CountryModel countryModel;
//    private LoaderManager loaderManager;
//    private String chosenCountryName;
    private Spinner spinner;
    private CompositeOnClickListener compositeOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating Spinner and Initializing it.
        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //get Desired button
        Button button = (Button) findViewById(R.id.submit_button);
        //initialize listener
        compositeOnClickListener = new CompositeOnClickListener();
        //set compositeOnclickListener to be the desired View Listener.
        button.setOnClickListener(compositeOnClickListener);

    }
}