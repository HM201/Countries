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
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.android.myapplication.CompositeOnClickListener.listeners;


public class weatherController extends Fragment implements AdapterView.OnClickListener, LoaderManager.LoaderCallbacks<weatherModel> {

    private final weatherController self = this;
    public weatherObserver weatherobserver;
    private String URL = "http://restapi.demoqa.com/utilities/weatherfull/city/";
    private weatherModel weathermodel;
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

        //define the weather observer
        weatherobserver = new weatherObserver();
        //define the weather model
        weathermodel = new weatherModel();

        weathermodel.addObserver(weatherobserver);
        // Get a reference to the LoaderManager, in order to interact with loaders.
        loaderManager = getLoaderManager();


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.weather_view, container, false);
    }

    @Override
    public Loader<weatherModel> onCreateLoader(int id, Bundle args) {
        //create new loader and pass to it the context
        return new weatherAsyncTaskLoader(getActivity(), URL + choosenName);
    }

    @Override
    public void onLoadFinished(Loader<weatherModel> loader, weatherModel weather) {

        // If there is a valid {@link country}, then add it to the adapter's
        // data set. This will trigger the country to update.
        if (weather != null /*&& !country.isEmpty()*/) {
            weathermodel.setTemperature(weather.getTemperature());
            weathermodel.setWindspeed(weather.getWindspeed());
            weathermodel.setWindDirection(weather.getWindDirection());
            weathermodel.setWeatherDesc(weather.getWeatherDesc());

            //add notify function.
//            weathermodel.notifyObservers();


            TextView temperature = (TextView) getActivity().findViewById(R.id.temp);
            temperature.setText(weathermodel.getTemperature());

            TextView windSpeed = (TextView) getActivity().findViewById(R.id.wind_speed);
            windSpeed.setText(weathermodel.getWindspeed());

            TextView windDirection = (TextView) getActivity().findViewById(R.id.wind_direction);
            windDirection.setText(weathermodel.getWindDirection());

            TextView windDesc = (TextView) getActivity().findViewById(R.id.weather_desc);
            windDesc.setText(weathermodel.getWeatherDesc());
        }
    }

    @Override
    public void onLoaderReset(Loader<weatherModel> loader) {

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