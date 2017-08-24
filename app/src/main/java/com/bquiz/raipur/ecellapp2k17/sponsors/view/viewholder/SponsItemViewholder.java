package com.bquiz.raipur.ecellapp2k17.sponsors.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bquiz.raipur.ecellapp2k17.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by iket on 3/8/17.
 */

public class SponsItemViewholder extends RecyclerView.ViewHolder {

    public final View rootView;
    public final TextView spons_name;
    public ImageView imageView;
    public final AVLoadingIndicatorView progressBar2;

    public SponsItemViewholder(View view) {
        super(view);

        rootView = view;
        imageView=(ImageView)view.findViewById(R.id.sponsImage);
        spons_name = (TextView) view.findViewById(R.id.spons_name);
        progressBar2 = (AVLoadingIndicatorView) view.findViewById(R.id.progressBar_spons_img);
    }
}
