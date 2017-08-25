package com.bquiz.raipur.ecellapp2k17.esummit.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bquiz.raipur.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.bquiz.raipur.ecellapp2k17.helper.image_loaders.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.esummit.model.data.SpeakerData;
import com.wang.avi.AVLoadingIndicatorView;
//import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by samveg on 14/8/17.
 */

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.ViewHolder> {

    private List<SpeakerData> data=new ArrayList<>();
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    Context context;

    public SpeakerAdapter(Context context1) {
        context=context1;
        layoutInflater=LayoutInflater.from(context1);
        imageLoader=new GlideImageLoader(context1);
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
        holder.speaker_year.setText(listData.getYear()+" ");
        imageLoader.load_circular_image(listData.getImage(),holder.speaker_image,holder.progressBar);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView speaker_image;
        public TextView speaker_name;
        public TextView speaker_desc;
        public TextView speaker_year;
        public final AVLoadingIndicatorView progressBar;


        public ViewHolder(View itemView) {
            super(itemView);
            speaker_image = (ImageView) itemView.findViewById(R.id.speakers_image);
            speaker_name = (TextView)itemView.findViewById(R.id.speakers_name);
            speaker_desc = (TextView) itemView.findViewById(R.id.speakers_desc);
            progressBar= (AVLoadingIndicatorView) itemView.findViewById(R.id.progressBar_speaker);
            speaker_year = (TextView) itemView.findViewById(R.id.year);
        }
    }
}
