package com.bquiz.raipur.ecellapp2k17.events.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.events.model.data.EventsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 22/6/17.
 */

public class VerticlePagerAdapter extends PagerAdapter {
    List<EventsData> listEvents=new ArrayList<>();

    Context mContext;
    LayoutInflater mLayoutInflater;
    private ImageView events_bg;
    private TextView event_body,event_venue;
    private Button btn_event_details;

    public VerticlePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    void setData(List<EventsData> eventsDatas)
    {
        this.listEvents=eventsDatas;
    }

    @Override
    public int getCount() {
        return listEvents.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.fragment_about_us, container, false);
        EventsData data=listEvents.get(position);

        events_bg = (ImageView) itemView.findViewById(R.id.eventImage);
        event_body = (TextView) itemView.findViewById(R.id.eventBody);
        event_venue = (TextView) itemView.findViewById(R.id.eventLocation);
        TextView label = (TextView) itemView.findViewById(R.id.eventTitle);
        label.setText(data.getEventName());
        event_body.setText(data.getDescription());
        event_venue.setText(data.getVenue());
        Glide.with(mContext).load(data.getMeta()).into(events_bg);
        container.addView(itemView);
/*
        btn_event_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
                //eventDetailsFragment.show(,"Event details");
            }
        });
*/

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
