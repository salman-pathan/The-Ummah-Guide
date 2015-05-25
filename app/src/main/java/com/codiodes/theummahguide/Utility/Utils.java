package com.codiodes.theummahguide.Utility;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.codiodes.theummahguide.R;

/**
 * Created by Salman on 5/21/2015.
 */
public class Utils {

    public static void stylizeActionBar(ActionBarActivity activity) {
        ActionBar bar = activity.getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(R.color.dark_green)));
        bar.setElevation(0);
        bar.setDisplayShowHomeEnabled(true);
        bar.setIcon(R.mipmap.ic_launcher);
    }

}
