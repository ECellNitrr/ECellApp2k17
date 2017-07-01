package com.example.iket.ecellapp2k17.home;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.about_us.view.AboutUsFragment;
import com.example.iket.ecellapp2k17.blogs.view.BlogFragment;
import com.example.iket.ecellapp2k17.events.view.EventsFragment;
import com.example.iket.ecellapp2k17.profile.view.ProfileFragment;
import com.example.iket.ecellapp2k17.sponsors.view.SponsFragment;

import java.util.List;

/**
 * Created by samveg on 27/5/17.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    private List<String> horizontalList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item_name;
        public ImageView tab_img;
        public RelativeLayout layout;

        public MyViewHolder(View view) {
            super(view);
            item_name = (TextView) view.findViewById(R.id.item_name);
            tab_img   = (ImageView) view.findViewById(R.id.tab_img);
            layout=(RelativeLayout)view.findViewById(R.id.tab_relative_layout);
        }
    }


    public HorizontalAdapter(List<String> horizontalList,Context context) {
        this.horizontalList = horizontalList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tab_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.item_name.setText(horizontalList.get(position));
        holder.tab_img.setImageURI(Uri.parse(horizontalList.get(position)));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position)
                {
                    case 0:
                        ((Home)context).setFragment(new ProfileFragment(),"Profile",1);
                        break;
                    case 1:
                        ((Home)context).setFragment(new EventsFragment(),"Events",2);
                        break;
                    case 2:
                        ((Home)context).setFragment(new BlogFragment(),"Blogs",3);
                        break;
                    case 3:
                        ((Home)context).setFragment(new SponsFragment(),"Sponsors",4);
                        break;
                    case 4:
                        ((Home)context).setFragment(new AboutUsFragment(),"AboutUs",5);
                        break;
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
