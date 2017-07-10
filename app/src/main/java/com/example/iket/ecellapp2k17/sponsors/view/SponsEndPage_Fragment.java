package com.example.iket.ecellapp2k17.sponsors.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.sponsors.model.MockSpons;
import com.example.iket.ecellapp2k17.sponsors.presenter.SponsPresenter;
import com.example.iket.ecellapp2k17.sponsors.presenter.SponsPresenterImpl;

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
    Button button;
    ImageView imageView;
    private SponsPresenter sponsPresenter;

    public SponsEndPage_Fragment(){
        //Required empty public constructor
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.spons_end_page, container, false);
        imageView = (ImageView) view.findViewById(R.id.sponsImage);
        //Rounded Corner imageview
        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.login_ecell)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 100, 100, mpaint);// Round Image Corner 100 100 100 100
        imageView.setImageBitmap(imageRounded);

        button = (Button) view.findViewById(R.id.sponsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       // sponsPresenter=new SponsPresenterImpl(this,new MockSpons());
        sponsPresenter.requestSpons();
        return view;
    }







}
