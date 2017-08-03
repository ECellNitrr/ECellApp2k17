package com.example.iket.ecellapp2k17.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.blogs.view.BlogFragment;

import java.util.ArrayList;

public class Home extends AppCompatActivity{

    private RecyclerView home_recycler;
    private ArrayList<Integer> tabitemList;
    private HorizontalAdapter horizontalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
