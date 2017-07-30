package com.example.iket.ecellapp2k17.sponsors.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;

import com.example.iket.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.example.iket.ecellapp2k17.helper.image_loaders.ImageLoader;
import com.example.iket.ecellapp2k17.home.Home;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 23/6/17.
 */

public class    SponsAdapter extends RecyclerView.Adapter<SponsAdapter.MyViewHolder>{
    private List<SponsData> sponsDataList= new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    private ImageView image1;
    public  LinearLayout layout;
    public SponsAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);
    }


    public void setData(List<SponsData> sponsData) {
        this.sponsDataList=sponsData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.spons_item, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        SponsData sponsData=sponsDataList.get(position);
        imageLoader.loadImage(sponsData.getImage1(), holder.image1);

//        holder.image1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                ((Home)context).setFragment(new SponsEndPage_Fragment(),"OYO",1);
//            }
//        });

        holder.sTitle.setText(sponsData.getsTitle());
        holder.rcimage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((Home)context).addFragment(new SponsEndPage_Fragment(),"Sponsor Details",15);
            }
        });

        }


    @Override
    public int getItemCount() {
        return this.sponsDataList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView image1,rcimage,cimage;
        private TextView sTitle;
        private MyViewHolder(View itemView) {
            super(itemView);
            image1= (ImageView) itemView.findViewById(R.id.sponsImage);
            rcimage = (ImageView) itemView.findViewById(R.id.rcImg);
            cimage = (ImageView) itemView.findViewById(R.id.circleImg);
            sTitle = (TextView)  itemView.findViewById(R.id.sponsTitle);
        }
    }

}

