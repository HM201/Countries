package com.example.android.myapplication;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.android.myapplication.CompositeOnClickListener.listeners;


public class CountryController extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<CountryModel> {

    private final CountryController self = this;
    public CountryObserver countryObserver;
    private String URL = "https://restcountries.eu/rest/v2/name/";
    private CountryModel countryModel;
    private LoaderManager loaderManager;
    private String choosenName;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //add fragment to list of listeners
        listeners.add(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        countryObserver = new CountryObserver();


        countryModel = new CountryModel();

        countryModel.addObserver(countryObserver);
        // Get a reference to the LoaderManager, in order to interact with loaders.
        loaderManager = getLoaderManager();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.country_view, container, false);
    }

    @Override
    public Loader<CountryModel> onCreateLoader(int id, Bundle args) {
        //create new loader and pass to it the context
        return new CountryAsyncTaskLoader(getActivity(), URL + choosenName);
    }

    @Override
    public void onLoadFinished(Loader<CountryModel> loader, CountryModel country) {
        // If there is a valid {@link country}, then add it to the adapter's
        // data set. This will trigger the country to update.
        if (country != null /*&& !country.isEmpty()*/) {
            countryModel.setCapital(country.getCapital());
            countryModel.setCurrency(country.getCurrency());
            countryModel.setLanguage(country.getLanguage());
            countryModel.setPopulation(country.getPopulation());
            countryModel.setName(country.getName());
            //add notify function.
//            countryModel.notifyObservers();


            TextView nameTextView = (TextView) getActivity().findViewById(R.id.name);
            nameTextView.setText(countryModel.getName());

            TextView currencyTextView = (TextView) getActivity().findViewById(R.id.currency);
            currencyTextView.setText(countryModel.getCurrency());

            TextView populationTextView = (TextView) getActivity().findViewById(R.id.population);
            populationTextView.setText(Integer.toString(countryModel.getPopulation()));

            TextView languageTextView = (TextView) getActivity().findViewById(R.id.language);
            languageTextView.setText(countryModel.getLanguage());

            TextView capitalTextView = (TextView) getActivity().findViewById(R.id.capital);
            capitalTextView.setText(countryModel.getCapital());

        }
    }

    @Override
    public void onLoaderReset(Loader<CountryModel> loader) {

    }

    @Override
    public void onClick(View v) {
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner);
        choosenName = spinner.getSelectedItem().toString();


        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().
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
}