package com.example.iket.ecellapp2k17.home;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 3/8/17.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    public HomeViewPagerAdapter(FragmentManager manager){
        super(manager);
    }

    private final List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 0;
    }


    public void addFrag(Fragment fragment) {
        mFragmentList.add(fragment);
    }
 }

