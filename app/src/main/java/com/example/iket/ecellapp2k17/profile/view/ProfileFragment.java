package com.example.iket.ecellapp2k17.profile.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.Profile;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.intrusoft.library.FrissonView;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment{

    private ImageView fb_image;
    private TextView fb_username,fb_email;
    private FrissonView wave;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SharedPrefs sharedPrefs;

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }


        fb_username = (TextView)view.findViewById(R.id.user_name_fb);
        fb_email = (TextView) view.findViewById(R.id.email_fb);
//        fb_email.setText(sharedPrefs.getEmail());
        fb_image=(ImageView)view.findViewById(R.id.center_image);
        Uri imageUri = Profile.getCurrentProfile().getProfilePictureUri(400, 400);
        String image_url = imageUri.toString();
        fb_username.setText(Profile.getCurrentProfile().getName());

        wave= (FrissonView) view.findViewById(R.id.wave);
        GlideImageLoader glideImageLoader=new GlideImageLoader(getContext());
        glideImageLoader.load_circular_image(image_url,fb_image);
        Glide.with(getContext())
                .load(imageUri)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(SimpleTarget.SIZE_ORIGINAL, SimpleTarget.SIZE_ORIGINAL) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {

                        wave.setBitmap(bitmap);
                    }
                });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}

//www.myc.com/wp-content/uploads/2016/07/0d36e7a476b06333d9fe9960572b66b9.jpg

