package com.example.android.myapplication;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hisham on 4/17/2018.
 * CompositeListener to solve the only one listener problem
 */

public class CompositeOnClickListener implements View.OnClickListener {
    //List of listeners to be informed of Click
    public static List<View.OnClickListener> listeners;

    public CompositeOnClickListener() {
        //initialize list of listeners
        listeners = new ArrayList<View.OnClickListener>();
    }

    //add Listener to Listeners List
    public void addOnClickListener(View.OnClickListener listener) {
        listeners.add(listener);
    }

    //notify each listener of the click in a for loop.
    @Override
    public void onClick(View v) {
        for (View.OnClickListener listener : listeners)
            listener.onClick(v);
    }
}
