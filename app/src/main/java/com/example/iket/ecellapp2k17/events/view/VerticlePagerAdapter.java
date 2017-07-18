package com.example.iket.ecellapp2k17.events.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;

/**
 * Created by samveg on 22/6/17.
 */

public class VerticlePagerAdapter extends PagerAdapter {
    String mResources[] = {"Wall Street","E summit"};

    Context mContext;
    LayoutInflater mLayoutInflater;

    public VerticlePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.events_item, container, false);

        TextView label = (TextView) itemView.findViewById(R.id.eventTitle);

        if (position % 2 == 0) {
            label.setText(mResources[0]);
        }
        else{
            label.setText(mResources[1]);
        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
