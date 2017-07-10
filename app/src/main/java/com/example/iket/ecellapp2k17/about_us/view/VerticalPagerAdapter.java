package com.example.iket.ecellapp2k17.about_us.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.about_us.model.data.AboutUsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class VerticalPagerAdapter extends PagerAdapter {

    private List<AboutUsData> aboutUsDataList = new ArrayList<>();
    Context mContext;
    LayoutInflater mLayoutInflater;

    public VerticalPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.aboutUsDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    void setAboutUsDataList(List<AboutUsData> aboutUsDataList){
        this.aboutUsDataList = aboutUsDataList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.about_us_card, container, false);

        AboutUsData data = aboutUsDataList.get(position);
        TextView title = (TextView) itemView.findViewById(R.id.aboutTitle);
        TextView body=(TextView)itemView.findViewById(R.id.aboutBody);
        title.setText(data.getAboutUsTitle());
        body.setText(data.getAboutUsBody());
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
