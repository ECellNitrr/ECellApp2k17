package com.example.iket.ecellapp2k17.about_us.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.about_us.model.data.AboutUsData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by samveg on 3/8/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<AboutUsData> data=new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;



    public RecyclerAdapter(Context context1) {
        context=context1;
        layoutInflater=LayoutInflater.from(context1);
    }
    public void setData(List<AboutUsData> data) {
        this.data = data;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=layoutInflater.inflate(R.layout.team_card,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        AboutUsData aboutUsData =  data.get(position);
        holder.member_name.setText(aboutUsData.getMember_name());
        if(position<4)
        {
            holder.member_email.setText(aboutUsData.getMember_email());
        }
        Glide.with(context).load(aboutUsData.getMember_img_url()).bitmapTransform(new CropCircleTransformation(context)).into(holder.member_image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView member_image;
        public TextView member_email;
        public TextView member_name;
        public ViewHolder(View itemView) {
            super(itemView);
            member_image = (ImageView) itemView.findViewById(R.id.coordinatorImg);
            member_email = (TextView) itemView.findViewById(R.id.coordinatorEmail);
            member_name = (TextView) itemView.findViewById(R.id.coordinatorName);
        }
    }
}
