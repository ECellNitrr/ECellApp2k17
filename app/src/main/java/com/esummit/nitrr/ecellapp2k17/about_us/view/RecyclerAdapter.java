package com.esummit.nitrr.ecellapp2k17.about_us.view;

import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.esummit.nitrr.ecellapp2k17.R;
import com.esummit.nitrr.ecellapp2k17.about_us.model.data.TeamData;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by samveg on 3/8/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<TeamData> data=new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;

    public RecyclerAdapter(Context context1) {
        context=context1;
        layoutInflater=LayoutInflater.from(context1);
    }
    public void setData(List<TeamData> data) {
        this.data = data;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=layoutInflater.inflate(R.layout.team_card,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, int position) {

        final TeamData teamData =  data.get(position);
        holder.member_name.setText(teamData.getName());
        holder.member_position.setText(teamData.getPosition());

        holder.member_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(context, Uri.parse(teamData.getLinkedIn()));

            }
        });

        Glide.with(context).load(teamData.getMeta()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                Log.d("Error",e+" \n"+teamData.getName());
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).bitmapTransform(new CropCircleTransformation(context)).into(holder.member_image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView member_image;
        public TextView member_email;
        public TextView member_name;
        public TextView member_position;
        public final AVLoadingIndicatorView progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            member_image = (ImageView) itemView.findViewById(R.id.coordinatorImg);
            member_email = (TextView) itemView.findViewById(R.id.coordinatorEmail);
            member_name = (TextView) itemView.findViewById(R.id.coordinatorName);
            progressBar = (AVLoadingIndicatorView) itemView.findViewById(R.id.progressBar_team);
            member_position = (TextView) itemView.findViewById(R.id.position);
        }
    }
}
