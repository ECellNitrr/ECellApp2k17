package com.example.iket.ecellapp2k17.blogs.view;

import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ForwardingListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.example.iket.ecellapp2k17.helper.image_loaders.RoundedCornersTransformation;
import com.example.iket.ecellapp2k17.home.Home;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;

import java.util.ArrayList;
import java.util.List;

import static com.example.iket.ecellapp2k17.helper.MyApplication.getContext;

public class VerticlePagerAdapter extends PagerAdapter {


    private List<BlogData> blogDataList = new ArrayList<>();
    Context mContext;
    LayoutInflater mLayoutInflater;
    private CardView blogCard;

    private String url = "http://google.com/";

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

        BlogData data=blogDataList.get(position);

        TextView title = (TextView) itemView.findViewById(R.id.blog_title);
        TextView owner=(TextView)itemView.findViewById(R.id.blog_owner);
        TextView date=(TextView)itemView.findViewById(R.id.blog_date);
        TextView body=(TextView)itemView.findViewById(R.id.blog_body);
        TextView read_more=(TextView)itemView.findViewById(R.id.blog_read_more);
        ImageView blogImage= (ImageView) itemView.findViewById(R.id.blog_image);
        RelativeLayout layout = (RelativeLayout) itemView.findViewById(R.id.blog_relative_layout);
        TextView info=(TextView)itemView.findViewById(R.id.info);
        info.setVisibility(View.GONE);

        Glide.with(mContext).load(data.getBlogImage()).into(blogImage);
        title.setText(data.getBlogTitle());
        owner.setText(data.getBlogOwner());
        date.setText(data.getBlogDate());
        body.setText(data.getBlogBody());
        container.addView(itemView);

//        blogCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((Home)mContext).addFragment(new BlogsDetailsFragment(),"More Blogs",18);
//            }
//        });

        read_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(mContext, Uri.parse(url));
            }
        });


        final ToolTipsManager mToolTipsManager;
        mToolTipsManager = new ToolTipsManager();
        final ToolTip.Builder builder = new ToolTip.Builder(mContext,read_more,layout, "" , ToolTip.GRAVITY_CENTER);
        builder.setGravity(ToolTip.ALIGN_CENTER);
        blogCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mToolTipsManager.show(builder.build());
                return false;
            }
        });
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
/*
    public void addFragment(Fragment fragment, String title, int data) {
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }
*/

}
