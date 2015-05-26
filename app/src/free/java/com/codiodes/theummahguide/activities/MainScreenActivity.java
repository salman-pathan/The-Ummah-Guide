package com.codiodes.theummahguide.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.afollestad.materialdialogs.MaterialDialog;
import com.codiodes.theummahguide.R;
import com.codiodes.theummahguide.Utility.Utils;
import com.codiodes.theummahguide.adapters.ViewPagerAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class MainScreenActivity extends ActionBarActivity implements MaterialTabListener {

    @InjectView(R.id.adView)
    AdView mAdView;

    @InjectView(R.id.materialTabHost)
    MaterialTabHost tabHost;

    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ButterKnife.inject(this);

        //  Change color of Action Bar.
        Utils.stylizeActionBar(this);

        //  Load Tab Bar
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                tabHost.setSelectedNavigationItem(position);
            }
        });

        for (int counter = 0; counter < mViewPagerAdapter.getCount(); counter++) {
            tabHost.addTab(tabHost.newTab()
            .setText(mViewPagerAdapter.getPageTitle(counter))
            .setTabListener(this)
            );
        }

        new MaterialDialog.Builder(this)
                .title(R.string.dialog_title)
                .content(R.string.dialog_content)
                .positiveText(R.string.positive_buton_text)
                .show();

        //  Load Advertisement
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {
        viewPager.setCurrentItem(materialTab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }
}
