package com.example.iket.ecellapp2k17.profile.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iket.ecellapp2k17.login.presenter.LoginData;
import com.example.iket.ecellapp2k17.login.presenter.LoginDataImp;
import com.example.iket.ecellapp2k17.login.provider.RetrofitLoginHelper;
import com.example.iket.ecellapp2k17.login.view.LoginView;
import com.example.iket.ecellapp2k17.otp_verify.model.OtpData;
import com.example.iket.ecellapp2k17.otp_verify.presenter.OtpVerifyPresenter;
import com.example.iket.ecellapp2k17.otp_verify.presenter.OtpVerifyPresenterImp;
import com.example.iket.ecellapp2k17.otp_verify.provider.RetrofitOtpVerifyHelper;
import com.example.iket.ecellapp2k17.otp_verify.view.OtpView;
import com.facebook.Profile;
import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;

import jp.wasabeef.glide.transformations.CropCircleTransformation;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements LoginView,OtpView{

    private ImageView fb_image,fb_image_bg;
    private TextView fb_username,fb_email,phoneTxt,log_out_txt,verify;
    private EditText username_etxt,email_etxt,phone_etxt,card_send_phone_etxt,card_send_otp_etxt;
    private Button editButton,saveButton,card_send_otp_btn,card_verify_otp_btn;
    private CardView cardview_otp;
    private  String mobileNo,otp,message;
    private LoginData loginData;
    private OtpVerifyPresenter otpVerifyPresenter;

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
        sharedPrefs = new SharedPrefs(getContext());
            initialize(view);
        if(sharedPrefs.isOtpLoggedIn()){
            verify.setVisibility(View.GONE);
        }
        if(sharedPrefs.getUsername()!=null){
            fb_username.setText(sharedPrefs.getUsername());
        }
       // else{  fb_username.setText(Profile.getCurrentProfile().getName()); }

        if(sharedPrefs.getEmail()!=null){
            fb_email.setText(sharedPrefs.getEmail());
        }

        if(sharedPrefs.getMobile()!=null){
            phoneTxt.setText(sharedPrefs.getMobile());
        }

         // fb_email.setText(sharedPrefs.getEmail());

        Uri imageUri = Profile.getCurrentProfile().getProfilePictureUri(400, 400);
        String image_url = imageUri.toString();
        Glide.with(getContext()).load(image_url).bitmapTransform(new CropCircleTransformation(getContext())).into(fb_image);
        Glide.with(getContext()).load(image_url).into(fb_image_bg);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb_username.setVisibility(View.GONE);
                fb_email.setVisibility(View.GONE);
                phoneTxt.setVisibility(View.GONE);
                username_etxt.setVisibility(View.VISIBLE);
                email_etxt.setVisibility(View.VISIBLE);
                phone_etxt.setVisibility(View.VISIBLE);
                editButton.setVisibility(View.GONE);
                saveButton.setVisibility(View.VISIBLE);
                log_out_txt.setVisibility(View.GONE);
                verify.setVisibility(View.GONE);

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               fb_username.setText(username_etxt.getText());
                fb_email.setText(email_etxt.getText());
                phoneTxt.setText(phone_etxt.getText());
                username_etxt.setVisibility(View.GONE);
                email_etxt.setVisibility(View.GONE);
                phone_etxt.setVisibility(View.GONE);
                fb_username.setVisibility(View.VISIBLE);
                fb_email.setVisibility(View.VISIBLE);
                phoneTxt.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.GONE);
                editButton.setVisibility(View.VISIBLE);
                log_out_txt.setVisibility(View.VISIBLE);
                verify.setVisibility(View.VISIBLE);

                sharedPrefs.setUsername(username_etxt.getText().toString());
                sharedPrefs.setEmailId(email_etxt.getText().toString());
                sharedPrefs.setMobile(phone_etxt.getText().toString());


            }
        });
    verify.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cardview_otp.setVisibility(View.VISIBLE);
            verify.setVisibility(View.GONE);
            mobileNo =card_send_phone_etxt.getText().toString();

            card_send_otp_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
/*
                    if(mobileNo.isEmpty()){
                        showError("Fields cannot be empty");
                    }
*/
                    {
                        loginData = new LoginDataImp(ProfileFragment.this, new RetrofitLoginHelper());
//                        loginData.getLoginData(mobileNo);
                        message = "false";
                    }
                }
            });
            card_verify_otp_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    otp = card_send_otp_etxt.getText().toString();
                    if(otp.isEmpty()){
                        showError("Fields cannot be empty");
                    }
                    else{
                        cardview_otp.setVisibility(View.GONE);
                        otpVerifyPresenter = new OtpVerifyPresenterImp(ProfileFragment.this, new RetrofitOtpVerifyHelper());
                        otpVerifyPresenter.otpData(otp, message);
                    }
                }
            });


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

    public void initialize(View view){
        card_send_otp_btn = (Button) view.findViewById(R.id.btn_send_otp);
        card_send_otp_etxt  = (EditText) view.findViewById(R.id.verify_otp_etxt);
        card_send_phone_etxt = (EditText) view.findViewById(R.id.send_phone_etxt);
        card_verify_otp_btn = (Button) view.findViewById(R.id.btn_verify_otp);
        cardview_otp = (CardView) view.findViewById(R.id.card_otp);
        verify = (TextView) view.findViewById(R.id.verify_txt);
        log_out_txt = (TextView) view.findViewById(R.id.log_out);
        username_etxt = (EditText) view.findViewById(R.id.user_name_fb_etxt);
        email_etxt = (EditText) view.findViewById(R.id.email_fb_etxt);
        phone_etxt = (EditText) view.findViewById(R.id.phone_etxt);
        editButton = (Button) view.findViewById(R.id.btn_edit);
        saveButton = (Button) view.findViewById(R.id.btn_save);
        phoneTxt = (TextView) view.findViewById(R.id.phone_txt);
        fb_username = (TextView)view.findViewById(R.id.user_name_fb);
        fb_email = (TextView) view.findViewById(R.id.email_fb);
        fb_image=(ImageView)view.findViewById(R.id.center_image);
        fb_image_bg = (ImageView)view.findViewById(R.id.profile_pic_bg);

    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @Override
    public void showLoginStatus(boolean login) {
        card_send_phone_etxt.setVisibility(View.GONE);
        card_send_otp_btn.setVisibility(View.GONE);
        card_send_otp_etxt.setVisibility(View.VISIBLE);
        card_verify_otp_btn.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void OtpStatus(OtpData otpData) {
        cardview_otp.setVisibility(View.GONE);
        sharedPrefs.setOtpLogin(true);
        Toast.makeText(getContext(),"OTP has been verified successfully",Toast.LENGTH_LONG);
    }
}

//www.myc.com/wp-content/uploads/2016/07/0d36e7a476b06333d9fe9960572b66b9.jpg

