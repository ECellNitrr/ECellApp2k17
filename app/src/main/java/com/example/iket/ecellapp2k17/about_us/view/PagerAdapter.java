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
import android.widget.ImageView;

import com.example.iket.ecellapp2k17.R;

import butterknife.BindView;

/**
 * Created by samveg on 17/8/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    public Context context;
    private int[] tabIcons = {R.drawable.vision_ic,R.drawable.team_ic,R.drawable.contact_us_ic};

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VisionFragment();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new TeamFragment();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new ContactUsFragment();
            default:
                return new VisionFragment();
        }
    }
    public View getTabView(int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        ImageView img = (ImageView) v.findViewById(R.id.tab_icon);
        img.setImageResource(tabIcons[position]);
        return v;
    }

}
