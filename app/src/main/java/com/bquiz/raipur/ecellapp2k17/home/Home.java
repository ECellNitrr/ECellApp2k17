package com.bquiz.raipur.ecellapp2k17.home;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.view.BQuizFragment;
import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.about_us.view.AboutUsFragment;
import com.bquiz.raipur.ecellapp2k17.blogs.view.BlogFragment;
import com.bquiz.raipur.ecellapp2k17.esummit.view.EsummitFragment;
import com.bquiz.raipur.ecellapp2k17.events.view.EventsFragment;
import com.bquiz.raipur.ecellapp2k17.profile.view.ProfileFragment;
import com.bquiz.raipur.ecellapp2k17.sponsors.view.SponsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class Home extends AppCompatActivity {

    private static Context context;


    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewPager_home)
    ViewPager viewPager;

    ImageView tab_icon_img;

    private int[] tabIcons = {R.drawable.e_summit_ic,R.drawable.events_icon_white,R.drawable.blogs_icon_white,R.drawable.sponsors_icon_white,R.drawable.bquiz_icon,R.drawable.about_us_white,R.drawable.profile_icon_white,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        this.context=this;
        setContentView(R.layout.activity_home);
        //setFragment(new EsummitFragment());
        ButterKnife.bind(this);

        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        adapter.addFragment(new EsummitFragment());
        adapter.addFragment(new EventsFragment());
        adapter.addFragment(new BlogFragment());
        adapter.addFragment(new SponsFragment());
        adapter.addFragment(new BQuizFragment());
        adapter.addFragment(new AboutUsFragment());
        adapter.addFragment(new ProfileFragment());
        adapter.notifyDataSetChanged();
        viewPager.setOffscreenPageLimit(7);
        setupTabIcons();
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));

    }
    private void setupTabIcons() {
        View view1;
        for (int i = 0; i < tabIcons.length; i++) {
            view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
            tab_icon_img = (ImageView) view1.findViewById(R.id.tab_icon);
            view1.findViewById(R.id.tab_icon);
            Glide.with(this).load(tabIcons[i]).into(tab_icon_img);
            tabLayout.getTabAt(i).setCustomView(view1);
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()==0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Home.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else
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


    public void addFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }

    public static Context getContext()
    {
        return context;
    }


}
