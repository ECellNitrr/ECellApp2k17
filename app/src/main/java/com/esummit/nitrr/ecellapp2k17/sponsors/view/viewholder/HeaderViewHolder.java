package com.esummit.nitrr.ecellapp2k17.sponsors.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.esummit.nitrr.ecellapp2k17.R;

/**
 * Created by iket on 3/8/17.
 */

 public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public final TextView sponsTitle;

    public HeaderViewHolder(View view) {
        super(view);

        sponsTitle = (TextView) view.findViewById(R.id.tvTitle);
    }
}