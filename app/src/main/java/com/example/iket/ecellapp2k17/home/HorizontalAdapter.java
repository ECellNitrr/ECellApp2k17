package com.example.iket.ecellapp2k17.home;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;

import java.util.List;

/**
 * Created by samveg on 27/5/17.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    private List<String> horizontalList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item_name;
        public ImageView tab_img;

        public MyViewHolder(View view) {
            super(view);
            item_name = (TextView) view.findViewById(R.id.item_name);
            tab_img   = (ImageView) view.findViewById(R.id.tab_img);
        }
    }


    public HorizontalAdapter(List<String> horizontalList) {
        this.horizontalList = horizontalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tab_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.item_name.setText(horizontalList.get(position));
        holder.tab_img.setImageURI(Uri.parse(horizontalList.get(position)));
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
