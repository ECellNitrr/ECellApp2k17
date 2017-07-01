package com.example.iket.ecellapp2k17.profile.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by samveg on 1/7/17.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    //integer to count number of tabs
    int tabCount;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
//Returning the current tabs
        switch (position) {
            case 0:
                ProfileTab profileTab = new ProfileTab();
                return profileTab;
            case 1:
                SettingsTab settingsTab = new SettingsTab();
                return settingsTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}