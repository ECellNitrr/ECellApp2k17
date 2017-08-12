package com.example.iket.ecellapp2k17.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


import com.example.iket.ecellapp2k17.BQuizNew.view.BQuizActivity;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.about_us.view.AboutUsFragment;
import com.example.iket.ecellapp2k17.blogs.view.BlogFragment;
import com.example.iket.ecellapp2k17.esummit.EsummitFragment;
import com.example.iket.ecellapp2k17.events.view.EventsFragment;
import com.example.iket.ecellapp2k17.profile.view.ProfileFragment;
import com.example.iket.ecellapp2k17.sponsors.view.SponsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity{

    @BindView(R.id.viewPager_home)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private int[] tabIcons = {R.drawable.esummit,R.drawable.events_icon_white,R.drawable.blogs_icon_white,R.drawable.sponsors_icon_white,R.drawable.about_us_white,R.drawable.about_us_white,R.drawable.profile_icon_white,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setFragment(new EsummitFragment());
        ButterKnife.bind(this);
        setupTabIcons();
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i=tabLayout.getSelectedTabPosition();
                switch (i)
                {
                    case 0:
                        setFragment(new EsummitFragment());
                        break;
                    case 1:
                        setFragment(new EventsFragment());
                        break;
                    case 2:
                        setFragment(new BlogFragment());
                        break;
                    case 3:
                        setFragment(new SponsFragment());
                        break;
                    case 4:
                        Intent bquiz=new Intent(Home.this, BQuizActivity.class);
                        startActivity(bquiz);
                        break;
                    case 5:
                        setFragment(new AboutUsFragment());
                        break;
                    case 6:
                        setFragment(new ProfileFragment());
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setupTabIcons() {
        View view1;
        for (int i = 0; i < tabIcons.length; i++) {
            view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
            view1.findViewById(R.id.tab_icon).setBackgroundResource(tabIcons[i]);
            tabLayout.addTab(tabLayout.newTab().setCustomView(view1));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @SuppressWarnings("StatementWithEmptyBody")

    public void setFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }

    public void addFragment(Fragment fragment, String s, int i) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
