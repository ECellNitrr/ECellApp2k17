package com.example.iket.ecellapp2k17.esummit.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerData;
//import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.example.iket.ecellapp2k17.R.id.progressBar;

/**
 * Created by samveg on 14/8/17.
 */

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.ViewHolder> {

    private List<SpeakerData> data=new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;

    public SpeakerAdapter(Context context1) {
        context=context1;
        layoutInflater=LayoutInflater.from(context1);
    }

    public void setData(List<SpeakerData> data) {
        this.data = data;
    }

    @Override
    public SpeakerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.speakers_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SpeakerAdapter.ViewHolder holder, int position) {
        SpeakerData listData = data.get(position);
        holder.speaker_name.setText(listData.getName());
        holder.speaker_desc.setText(listData.getDescription());
        Glide.with(context).load(listData.getImage()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                holder.progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).bitmapTransform(new CropCircleTransformation(context)).into(holder.speaker_image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView speaker_image;
        public TextView speaker_name;
        public TextView speaker_desc;
//        public final AVLoadingIndicatorView progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            speaker_image = (ImageView) itemView.findViewById(R.id.speakers_image);
            speaker_name = (TextView)itemView.findViewById(R.id.speakers_name);
            speaker_desc = (TextView) itemView.findViewById(R.id.speakers_desc);
//            progressBar= (AVLoadingIndicatorView) itemView.findViewById(R.id.progressBar_speaker);
        }
    }
}
