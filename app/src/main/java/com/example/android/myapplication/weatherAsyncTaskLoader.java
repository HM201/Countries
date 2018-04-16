package com.example.android.myapplication;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by Satellite on 4/16/2018.
 */

public class weatherAsyncTaskLoader extends AsyncTaskLoader<weatherModel> {
    private String url;

    public weatherAsyncTaskLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public weatherModel loadInBackground() {
        if (url == null)
            return null;
        //fetch country data from json file
        weatherModel weathermodel = weatherQueryUtils.fetchWeatherData(url);
        return weathermodel;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
