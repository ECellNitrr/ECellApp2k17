package com.example.iket.ecellapp2k17.events.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.events.model.data.EventsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 22/6/17.
 */

public class VerticlePagerAdapter extends PagerAdapter {
    List<EventsData> listEvents=new ArrayList<>();

    Context mContext;
    LayoutInflater mLayoutInflater;

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
        View itemView = mLayoutInflater.inflate(R.layout.events_item, container, false);

        EventsData data=listEvents.get(position);
        TextView label = (TextView) itemView.findViewById(R.id.eventTitle);
        label.setText(data.getEventName());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
