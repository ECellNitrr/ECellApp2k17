package com.example.iket.ecellapp2k17.about_us.view;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;

import com.example.iket.ecellapp2k17.R;

import butterknife.BindView;

/**
 * Created by samveg on 17/8/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VisionFragment();
            case 1:
                return new TeamFragment();
            case 2:
                return new ContactUsFragment();
            default:
                return new VisionFragment();
        }
    }

}
