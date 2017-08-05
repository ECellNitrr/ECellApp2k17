package com.example.iket.ecellapp2k17.sponsors.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;

/**
 * Created by iket on 3/8/17.
 */

public class SponsItemViewholder extends RecyclerView.ViewHolder {

    public final View rootView;
    public final TextView spons_name;

    public SponsItemViewholder(View view) {
        super(view);

        rootView = view;
        spons_name = (TextView) view.findViewById(R.id.spons_name);
    }
}
