package com.example.iket.ecellapp2k17.blogs.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class VerticlePagerAdapter extends PagerAdapter  {


    private List<BlogData> blogDataList = new ArrayList<>();
    Context mContext;
    LayoutInflater mLayoutInflater;
    private CardView blogCard;
    private int length;
    private AVLoadingIndicatorView progressBar;

   // private String url = "http://google.com/";

    public VerticlePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.blogDataList.size()+1;
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



        TextView title = (TextView) itemView.findViewById(R.id.blog_title);
//        TextView owner=(TextView)itemView.findViewById(R.id.blog_owner);
        TextView date=(TextView)itemView.findViewById(R.id.blog_date);
        TextView body=(TextView)itemView.findViewById(R.id.blog_body);
        TextView read_more=(TextView)itemView.findViewById(R.id.blog_read_more);
        ImageView blogImage= (ImageView) itemView.findViewById(R.id.blog_image);
        progressBar = (AVLoadingIndicatorView) itemView.findViewById(R.id.progressBar_blogs);
        RelativeLayout layout = (RelativeLayout) itemView.findViewById(R.id.blog_relative_layout);

        if(position < blogDataList.size())
        {
            final BlogData data=blogDataList.get(position);
            length = (data.getBody()).length();
            if(length>270)
            {
                read_more.setVisibility(View.VISIBLE);
            }
            else
            {
                read_more.setVisibility(View.INVISIBLE);
                read_more.setClickable(false);
            }

            Glide.with(mContext).load(data.getImage()).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).into(blogImage);
            title.setText(data.getTitle());
            date.setText(data.getDate());
            body.setText(Html.fromHtml(Html.fromHtml(data.getBody()).toString()));


            read_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentActivity activity = (FragmentActivity)(mContext);
                    FragmentManager fm = activity.getSupportFragmentManager();
                    ReadMoreBlogsFragment readMoreBlogsFragment = new ReadMoreBlogsFragment();
                    readMoreBlogsFragment.setData(data);
                    readMoreBlogsFragment.show(fm, "read_more");


                /*
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                try {
                    customTabsIntent.launchUrl(mContext, Uri.parse(data.getUrl()));
                }
                catch (Exception e)
                {
                    Toast.makeText(mContext, "Error opening custom tabs", Toast.LENGTH_SHORT).show();
                }
                */


                }
            });

        }
        else
        {
            Glide.with(mContext).load("http://cdn2.hubspot.net/hub/53/file-23115630-jpg/blog/images/blogging_image.jpg").listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).into(blogImage);
            body.setText("Wait for more blogs...." +
                    "You can write your own blog by pressing the bottom-right icon.");
            read_more.setVisibility(View.INVISIBLE);

        }
        container.addView(itemView);





        final ToolTipsManager mToolTipsManager;
        mToolTipsManager = new ToolTipsManager();
        final ToolTip.Builder builder = new ToolTip.Builder(mContext,title,layout, "Swipe up to read next blog." , ToolTip.POSITION_ABOVE);
        builder.setBackgroundColor(R.color.black);

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
