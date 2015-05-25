package com.codiodes.theummahguide.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codiodes.theummahguide.R;
import com.codiodes.theummahguide.fragments.FragmentText;

/**
 * Created by Salman on 5/21/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    public static final int TAB_COUNT = 3;
    Context mContext;
    String[] mTabTitles = {"Quran", "Sunnah", "Ijma"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new FragmentText();
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }
}
