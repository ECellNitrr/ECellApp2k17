package com.example.iket.ecellapp2k17.events.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.events.model.data.EventsData;
import com.example.iket.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.example.iket.ecellapp2k17.helper.image_loaders.ImageLoader;
import com.example.iket.ecellapp2k17.helper.image_loaders.RoundedCornersTransformation;
import com.example.iket.ecellapp2k17.home.Home;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 5/8/17.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private List<EventsData> data = new ArrayList<>();
    Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public EventsAdapter(Context context1) {
        context = context1;
        layoutInflater = LayoutInflater.from(context1);
       imageLoader = new GlideImageLoader(context);
    }
    void setData(List<EventsData> data)
    {
        this.data = data;
    }


    @Override
    public EventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = layoutInflater.inflate(R.layout.events_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final EventsData eventsData = data.get(position);
       imageLoader.loadImage(eventsData.getMeta(),holder.event_image);
        Glide.with(context).load(eventsData.getMeta()).bitmapTransform(new RoundedCornersTransformation(context,20,0)).into(holder.event_image);
        holder.event_name.setText(eventsData.getEventName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventDetailsFragment eventDetailsFragment=new EventDetailsFragment();
                eventDetailsFragment.setData(eventsData);
                ((Home)context).addFragment(eventDetailsFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView event_image;
        public RelativeLayout relativeLayout;
        public TextView event_name;
        public MyViewHolder(View itemView){
            super(itemView);
            event_image = (ImageView) itemView.findViewById(R.id.eventImg);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.event_relativeLayout);
            event_name = (TextView) itemView.findViewById(R.id.eventName);
        }
    }
}
