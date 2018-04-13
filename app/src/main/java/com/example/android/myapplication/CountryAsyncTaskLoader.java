package com.example.android.myapplication;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by Hisham on 4/11/2018.
 */

public class CountryAsyncTaskLoader extends AsyncTaskLoader<CountryModel> {
    private String url;

    public CountryAsyncTaskLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public CountryModel loadInBackground() {
        if(url==null)
            return null;
        //fetch country data from json file
        CountryModel countryModel = CountryQueryUtils.fetchCountryData(url);
        return countryModel;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
