package com.example.android.myapplication;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, LoaderManager.LoaderCallbacks<CountryModel> {

    private final MainActivity self = this;
    public CountryObserver countryObserver;
    private String URL = "https://restcountries.eu/rest/v2/name/";
    private String chosenCountryName;
    private CountryModel countryModel;
    private Spinner spinner;
    private LoaderManager loaderManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryObserver = new CountryObserver();
//        final CountryModel countryModel = new CountryModel("Egypt","EGP"
//                ,90000000,"egyptian","mamlaket El tawab2");


        countryModel = new CountryModel();

        countryModel.addObserver(countryObserver);
        // Get a reference to the LoaderManager, in order to interact with loaders.
        loaderManager = getLoaderManager();


        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        ((Spinner) findViewById(R.id.spinner)).setOnItemSelectedListener(self);


    }

    @Override
    public Loader<CountryModel> onCreateLoader(int id, Bundle args) {
        //create new loader and pass to it the context
        return new CountryAsyncTaskLoader(this, URL + chosenCountryName);
    }

    @Override
    public void onLoadFinished(Loader<CountryModel> loader, CountryModel country) {
//        if (country.isEmpty())
//            EmptyStateTextView.setText("No Earthquakes Found");
//        ProgressBar progressBar = (ProgressBar)findViewById(R.id.loading_spinner);
//        progressBar.setVisibility(View.GONE);
//        // Clear the adapter of previous earthquake data
//        adapter.clear();

        // If there is a valid {@link country}, then add it to the adapter's
        // data set. This will trigger the country to update.
        if (country != null /*&& !country.isEmpty()*/) {
            countryModel.setCapital(country.getCapital());
            countryModel.setCurrency(country.getCurrency());
            countryModel.setLanguage(country.getLanguage());
            countryModel.setPopulation(country.getPopulation());
            countryModel.setName(country.getName());
            //add notify function.
            countryModel.notifyObservers();


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

    @Override
    public void onLoaderReset(Loader<CountryModel> loader) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosenCountryName = parent.getItemAtPosition(position).toString();


        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {


            if (loaderManager.getLoader(1) == null) {

                // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                // because this activity implements the LoaderCallbacks interface).
                loaderManager.initLoader(1, null, this);
            } else {
                loaderManager.restartLoader(1, null, this);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}