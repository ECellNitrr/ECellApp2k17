package com.example.iket.ecellapp2k17.profile.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iket.ecellapp2k17.R;

/**
 * Created by samveg on 1/7/17.
 */

public class ProfileTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.profile_tab_item, container, false);
    }

}
