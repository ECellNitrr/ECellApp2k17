package com.example.iket.ecellapp2k17.profile.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import android.media.Image;
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

import com.example.iket.ecellapp2k17.helper.NetworkUtils;
import com.example.iket.ecellapp2k17.login.model.LoginDataResponse;
import com.example.iket.ecellapp2k17.login.presenter.LoginData;
import com.example.iket.ecellapp2k17.login.presenter.LoginDataImp;
import com.example.iket.ecellapp2k17.login.provider.RetrofitLoginHelper;
import com.example.iket.ecellapp2k17.login.view.LoginActivity;
import com.example.iket.ecellapp2k17.login.view.LoginView;
import com.facebook.Profile;
import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.wasabeef.glide.transformations.CropCircleTransformation;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements LoginView{

    private ImageView fb_image,profile_bg;
    private TextView fb_username,fb_email,phoneTxt,log_out_txt,initials_txt;
    private EditText username_etxt,email_etxt;
    private Button editButton,saveButton,cancelButton;
    private  String edit_name,edit_mobile,edit_email,s,initials;
    private char c,d;
    private CardView card_edit_details;
    private int l,i;
    private LoginData loginData;

    Dialog dialog;

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
        final View view=inflater.inflate(R.layout.fragment_profile, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

        sharedPrefs = new SharedPrefs(getContext());
            initialize(view);
        card_edit_details.setVisibility(View.GONE);

        if(sharedPrefs.getUsername()!=null){
            fb_username.setText(sharedPrefs.getUsername());
        }

        if(sharedPrefs.getEmail()!=null){
            fb_email.setText(sharedPrefs.getEmail());
        }

        if(sharedPrefs.getMobile()!=null){
            phoneTxt.setText(sharedPrefs.getMobile());
        }
        s=fb_username.getText().toString();
        s.trim();
        s.toUpperCase();
        c=s.charAt(0);
        l=s.indexOf(" ");
        d=s.charAt(l+1);
        initials = (""+c+d).toUpperCase();
        initials_txt.setText(initials);

  //      Glide.with(getContext()).load(R.drawable.profile_bg).into(profile_bg);
  //      Glide.with(getContext()).load(R.drawable.default_fb_pic).bitmapTransform(new CropCircleTransformation(getContext())).into(fb_image);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editButton.setVisibility(View.GONE);
                card_edit_details.setVisibility(View.VISIBLE);


            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit_name = username_etxt.getText().toString();
                edit_email = email_etxt.getText().toString();
                edit_mobile = phoneTxt.getText().toString();

                log_out_txt.setVisibility(View.VISIBLE);
                /*
                s=username_etxt.getText().toString();
                s.trim();
                c=s.charAt(0);
                l=s.indexOf(" ");
                d=s.charAt(l+1);
                initials = (""+c+d).toUpperCase();
                initials_txt.setText(initials);

               sharedPrefs.setUsername(username_etxt.getText().toString());
                sharedPrefs.setEmailId(email_etxt.getText().toString());
                */
                if(edit_name.isEmpty() ||  edit_email.isEmpty()){
                    Toast.makeText(getContext(),"Fields cannot be empty!",Toast.LENGTH_SHORT).show();
                }
                else if(emailInvalid(edit_email)){
                    Toast.makeText(getContext(), "ENTER CORRECT EMAIL ID!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    loginData = new LoginDataImp(ProfileFragment.this, new RetrofitLoginHelper());
                    loginData.getLoginData(edit_name, edit_mobile,edit_email);
                    Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                    card_edit_details.setVisibility(View.GONE);
                    fb_username.setText(edit_name);
                    fb_email.setText(edit_email);
                    editButton.setVisibility(View.VISIBLE);
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editButton.setVisibility(View.VISIBLE);
                fb_username.setText(sharedPrefs.getUsername());
                fb_email.setText(sharedPrefs.getEmail());
                card_edit_details.setVisibility(View.GONE);
            }
        });

        log_out_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefs.setLogin(false);
                getActivity().finish();
                Intent i = new Intent(getContext(), LoginActivity.class);
                startActivity(i);

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
        card_edit_details = (CardView) view.findViewById(R.id.card_edit);
        log_out_txt = (TextView) view.findViewById(R.id.log_out);
        username_etxt = (EditText) view.findViewById(R.id.user_name_fb_etxt);
        email_etxt = (EditText) view.findViewById(R.id.email_fb_etxt);
        editButton = (Button) view.findViewById(R.id.btn_edit);
        saveButton = (Button) view.findViewById(R.id.btn_save);
        phoneTxt = (TextView) view.findViewById(R.id.phone_txt);
        fb_username = (TextView)view.findViewById(R.id.user_name_fb);
        fb_email = (TextView) view.findViewById(R.id.email_fb);
        fb_image=(ImageView)view.findViewById(R.id.center_image);
        cancelButton = (Button) view.findViewById(R.id.btn_cancel);
        initials_txt = (TextView) view.findViewById(R.id.initial);
       // profile_bg = (ImageView) view.findViewById(R.id.profile_bg_img);
    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @Override
    public void showLoginStatus(LoginDataResponse loginDataResponse) {
        card_edit_details.setVisibility(View.GONE);
        fb_username.setText(username_etxt.getText());
        fb_email.setText(email_etxt.getText());
        sharedPrefs.setUsername(username_etxt.getText().toString());
        sharedPrefs.setEmailId(email_etxt.getText().toString());

        s=username_etxt.getText().toString();
        s.trim();
        c=s.charAt(0);
        l=s.indexOf(" ");
        d=s.charAt(l+1);
        initials = (""+c+d).toUpperCase();
        initials_txt.setText(initials);

        Toast.makeText(getContext(),"Your Details has been Updated Successfully!",Toast.LENGTH_LONG);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void checkNetwork() {
        if(!NetworkUtils.isNetworkAvailable(getContext())){
            dialog = new Dialog(getContext());
            dialog.setContentView(R.layout.activity_rules__dialog_box);
            Button btn = (Button) dialog.findViewById(R.id.dialog_button);
            TextView rules5 = (TextView) dialog.findViewById(R.id.rules5);
            btn.setText("Retry");
            rules5.setText("No internet connection.Please try again.");
            dialog.setTitle("Connectivity Failed");
            dialog.setCancelable(false);
            dialog.show();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    loginData = new LoginDataImp(ProfileFragment.this, new RetrofitLoginHelper());
                    loginData.getLoginData(edit_name, edit_mobile,edit_email);
                    dialog.dismiss();
                }
            });
        }
    }

    public boolean emailInvalid(String email) {
        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        boolean a = matcher.matches();
        return !a;
    }

}


