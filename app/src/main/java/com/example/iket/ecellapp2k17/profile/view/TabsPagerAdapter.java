package com.example.iket.ecellapp2k17.profile.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by samveg on 1/7/17.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    //integer to count number of tabs
    final int TAB_COUNT = 2;
    private String tabTitles[] = new String[]{"Profile","Settings"};

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//Returning the current tabs
        switch (position) {
            case 0:
                return new ProfileTab();
            case 1:
                return new SettingsTab();
            default:
                return new ProfileTab();
        }
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}