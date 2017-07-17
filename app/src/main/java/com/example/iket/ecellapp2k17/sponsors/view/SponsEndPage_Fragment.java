package com.example.iket.ecellapp2k17.sponsors.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.example.iket.ecellapp2k17.helper.image_loaders.ImageLoader;
import com.example.iket.ecellapp2k17.sponsors.model.MockSpons;
import com.example.iket.ecellapp2k17.sponsors.presenter.SponsPresenter;
import com.example.iket.ecellapp2k17.sponsors.presenter.SponsPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 6/27/2017.
 */

public class SponsEndPage_Fragment extends Fragment implements SponsInterface{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button;
    private ImageView image1;
    private TextView textTitle;
    private Context context;
    private SponsPresenter sponsPresenter;
    private   SponsData sponsData;
    private RelativeLayout relativeLayout;



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
        Glide.with(this).load(R.drawable.sample_logo).into(image1);
        textTitle = (TextView) view.findViewById(R.id.sponsTitle);
//        textTitle.setText(sponsData.getsTitle());
       //Glide.with(this)
        //   .load(R.drawable.spons_endpage).into(new LinearLayoutTarget(this, (RelativeLayout) yourLinearLayoutInstanceHere));
/*
        Glide.with(this).load(R.drawable.spons_endpage).asBitmap().into(new SimpleTarget<Bitmap>(250, 250) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(drawable);
                }
            }
        });

*/


        button = (Button) view.findViewById(R.id.sponsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.yourURL.com"));//Url will be provided..
                startActivity(intent);
            }
        });
        sponsPresenter=new SponsPresenterImpl(this,new MockSpons());
        sponsPresenter.requestSpons();
        return view;
    }

    @Override
    public void setData(List<SponsData> sponsDataList) {

    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void showMessage(String message) {

    }
}


