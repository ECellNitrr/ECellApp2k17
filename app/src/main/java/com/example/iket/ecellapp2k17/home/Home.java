package com.example.iket.ecellapp2k17.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.about_us.view.AboutUsFragment;
import com.example.iket.ecellapp2k17.blogs.view.BlogFragment;
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

    private HomeViewPagerAdapter homeViewPagerAdapter;
    private Context context;
    private int[] tabIcons = {R.drawable.profile_icon_white,R.drawable.events_icon_white,R.drawable.blogs_icon_white,R.drawable.sponsors_icon_white,R.drawable.about_us_white};

    /*
    private RecyclerView home_recycler;
    private ArrayList<Integer> tabitemList;
    private HorizontalAdapter horizontalAdapter;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager.setOffscreenPageLimit(homeViewPagerAdapter.getCount());
/*
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==5){
                    Intent i = new Intent(Home.this,BQuizActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
     */
        //setupTabIcons();
/*
        home_recycler = (RecyclerView) findViewById(R.id.home_recycler);

        tabitemList=new ArrayList<>();
        tabitemList.add(R.drawable.profile_icon);
        tabitemList.add(R.drawable.events_icon);
        tabitemList.add(R.drawable.blogs_icon);
        tabitemList.add(R.drawable.sponsors_icon);
        tabitemList.add(R.drawable.aboutus);
        tabitemList.add(R.drawable.aboutus);
        horizontalAdapter=new HorizontalAdapter(tabitemList,this);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);

        home_recycler.setLayoutManager(horizontalLayoutManagaer);
        home_recycler.setAdapter(horizontalAdapter);

        setFragment(new BlogFragment(),"Blogs",3);
        */
    }
    private void setupTabIcons() {
       tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    private void setupViewPager(ViewPager viewPager){
        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        homeViewPagerAdapter.addFrag(new ProfileFragment(),"Profile");
        homeViewPagerAdapter.addFrag(new EventsFragment(),"Events");
        homeViewPagerAdapter.addFrag(new BlogFragment(),"Blogs");
        homeViewPagerAdapter.addFrag(new SponsFragment(),"Sponsor");
        homeViewPagerAdapter.addFrag(new AboutUsFragment(),"About Us");
        viewPager.setAdapter(homeViewPagerAdapter);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @SuppressWarnings("StatementWithEmptyBody")

    public void setFragment(Fragment fragment, String title, int data) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }

    public void addFragment(Fragment fragment, String title, int data) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
