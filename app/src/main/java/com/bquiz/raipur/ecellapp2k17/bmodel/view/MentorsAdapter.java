package com.bquiz.raipur.ecellapp2k17.bmodel.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.bmodel.model.data.MentorData;
import com.bumptech.glide.Glide;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 29/8/17.
 */

public class MentorsAdapter extends RecyclerView.Adapter<MentorsAdapter.ViewHolder> {

    private List<MentorData> data=new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;

    public MentorsAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }


    public void setData(List<MentorData> data) {
        this.data = data;
    }

    @Override
    public MentorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.mentors_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MentorsAdapter.ViewHolder holder, int position) {
        MentorData listData =data.get(position);
        holder.mentor_name.setText(listData.getName());
        holder.mentor_description.setText(listData.getDescription());
        Glide.with(context).load(listData.getImage()).into(holder.mentor_image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mentor_image;
        public TextView mentor_name;
        public TextView mentor_description;
        public final AVLoadingIndicatorView progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            mentor_name = (TextView) itemView.findViewById(R.id.mentors_name);
            mentor_image= (ImageView) itemView.findViewById(R.id.mentors_image);
            mentor_description = (TextView) itemView.findViewById(R.id.mentors_desc);
            progressBar = (AVLoadingIndicatorView) itemView.findViewById(R.id.progressBar_mentor);
        }
    }
}
