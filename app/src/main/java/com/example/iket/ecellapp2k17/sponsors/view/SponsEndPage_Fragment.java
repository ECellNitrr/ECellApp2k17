package com.example.iket.ecellapp2k17.sponsors.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.sponsors.model.data.SponsData;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by vrihas on 6/27/2017.
 */

public class SponsEndPage_Fragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button;
    private ImageView image1,bg_spons;
    private SponsData sponsData;
    private TextView textTitle,spons_desc,spons_body;
    private Context context;

    public SponsEndPage_Fragment(){
        //Required empty constructor
    }


    public static SponsEndPage_Fragment newInstance(String param1, String param2) {
        SponsEndPage_Fragment sponsEndPage_fragment = new SponsEndPage_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        sponsEndPage_fragment.setArguments(args);
        return sponsEndPage_fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.spons_end_page, container, false);
        image1 = (ImageView) view.findViewById(R.id.sponsImage);
        bg_spons = (ImageView) view.findViewById(R.id.bgSpons);
        textTitle = (TextView) view.findViewById(R.id.sponsTitle);
        spons_desc = (TextView) view.findViewById(R.id.sponsDesc);
        spons_body = (TextView) view.findViewById(R.id.sponsBody);
        button = (Button) view.findViewById(R.id.sponsButton);


        Glide.with(this).load(R.drawable.spons_endpage).into(bg_spons);//  sponsData.getBg_spons()
        int radius = 30; // corner radius, higher value = more rounded
        int margin = 5;
        Glide.with(this)
                .load(sponsData.getImage1())  //sponsData.getImage1
                .bitmapTransform(new RoundedCornersTransformation(context, radius, margin))
                .into(image1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(),Uri.parse(sponsData.getWebsite_url()));
            }
        });

        return view;
    }


    public void setData(final SponsData data) {
        sponsData=data;
    }

}


