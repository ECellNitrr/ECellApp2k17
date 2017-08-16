package com.example.iket.ecellapp2k17.blogs.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;

import java.util.ArrayList;
import java.util.List;

public class VerticlePagerAdapter extends PagerAdapter {


    private List<BlogData> blogDataList = new ArrayList<>();
    Context mContext;
    LayoutInflater mLayoutInflater;
    private CardView blogCard;
    private int length;

   // private String url = "http://google.com/";

    public VerticlePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.blogDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    void setBlogDataList(List<BlogData> blogDataList)
    {
        this.blogDataList=blogDataList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.blog_card, container, false);

        blogCard = (CardView) itemView.findViewById(R.id.blogCard);

        final BlogData data=blogDataList.get(position);

        TextView title = (TextView) itemView.findViewById(R.id.blog_title);
//        TextView owner=(TextView)itemView.findViewById(R.id.blog_owner);
        TextView date=(TextView)itemView.findViewById(R.id.blog_date);
        TextView body=(TextView)itemView.findViewById(R.id.blog_body);
        TextView read_more=(TextView)itemView.findViewById(R.id.blog_read_more);
        ImageView blogImage= (ImageView) itemView.findViewById(R.id.blog_image);
        RelativeLayout layout = (RelativeLayout) itemView.findViewById(R.id.blog_relative_layout);
        TextView info=(TextView)itemView.findViewById(R.id.info);
        /*
        length = (data.getBody()).length();
        if(length>370)
        {
            read_more.setVisibility(View.VISIBLE);
        }
        else
        {
            read_more.setVisibility(View.GONE);
        }
        info.setVisibility(View.GONE);
        */
        Glide.with(mContext).load(data.getImage()).into(blogImage);
        title.setText(data.getTitle());
//        owner.setText(data.getBlogOwner());
        date.setText(data.getDate());
        body.setText(Html.fromHtml(Html.fromHtml(data.getBody()).toString()));
        container.addView(itemView);


        read_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(mContext, Uri.parse(data.getUrl()));
            }
        });


        final ToolTipsManager mToolTipsManager;
        mToolTipsManager = new ToolTipsManager();
        final ToolTip.Builder builder = new ToolTip.Builder(mContext,blogImage,layout, "Swipe up to read next blog." , ToolTip.POSITION_BELOW);
        builder.setBackgroundColor(R.color.dak_grey);

        if(position==0) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToolTipsManager.show(builder.build());
                }
            },3000);
        }
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
