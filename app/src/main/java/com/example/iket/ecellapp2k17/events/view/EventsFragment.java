package com.example.iket.ecellapp2k17.events.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iket.ecellapp2k17.R;

/**
 * Created by vrihas on 30/5/17.
 */

public class EventsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.events_item, container, false);

                return rootView;

    }
}
