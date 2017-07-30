package com.example.iket.ecellapp2k17.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.blogs.view.BlogFragment;
import com.facebook.appevents.AppEventsLogger;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private Menu menu;
    private RecyclerView home_recycler;
    private ArrayList<Integer> tabitemList;
    private HorizontalAdapter horizontalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_recycler = (RecyclerView) findViewById(R.id.home_recycler);
//        samveg:- Add arraay in string.xml file
        tabitemList=new ArrayList<>();
        tabitemList.add(R.drawable.profile_icon);
        tabitemList.add(R.drawable.events_icon);
        tabitemList.add(R.drawable.blogs_icon);
        tabitemList.add(R.drawable.sponsors_icon);
        tabitemList.add(R.drawable.aboutus);
        horizontalAdapter=new HorizontalAdapter(tabitemList,this);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);

        home_recycler.setLayoutManager(horizontalLayoutManagaer);
        home_recycler.setAdapter(horizontalAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView= (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.inflateMenu(R.menu.events_menu);

        setFragment(new BlogFragment(),"Blogs",3);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about_vision) {
            // Handle the camera action
        } else if (id == R.id.recent_blogs) {

        } else if (id == R.id.become_our_sponsor) {

        } else if (id == R.id.log_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(Fragment fragment, String title, int data) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
        navigation_menu(data);

    }

    public void addFragment(Fragment fragment, String title, int data) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
        navigation_menu(data);
    }

    void navigation_menu(int data)
    {
        menu=navigationView.getMenu();
        menu.setGroupVisible(R.id.menu_group,false);
        switch (data)
        {
            case 1:
                navigationView.inflateMenu(R.menu.profile_menu);
                break;
            case 2:
                navigationView.inflateMenu(R.menu.events_menu);
                break;
            case 3:
                navigationView.inflateMenu(R.menu.blogs_menu);
                break;
            case 4:
                navigationView.inflateMenu(R.menu.spons_menu);
                break;
            case 5:
                navigationView.inflateMenu(R.menu.about_us_menu);
                break;
        }
    }

}
