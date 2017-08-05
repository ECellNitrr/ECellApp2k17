package com.example.iket.ecellapp2k17.fb;



import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.home.Home;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;


import com.example.iket.ecellapp2k17.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.example.iket.ecellapp2k17.R.id.e_cell_logo;
import static com.example.iket.ecellapp2k17.R.id.linearLayout;
import static com.example.iket.ecellapp2k17.R.id.login_background;
import static com.example.iket.ecellapp2k17.R.id.mobile_img;
import static com.example.iket.ecellapp2k17.R.id.otp_img;
import static com.example.iket.ecellapp2k17.helper.MyApplication.getContext;

public class fb_login extends AppCompatActivity {

    CallbackManager callbackManager;
    LoginButton loginButton;
    //ImageView imageView;
    ProfilePictureView profile_pic;
    //String userName;
    private SharedPrefs sharedPrefs;
    @BindView(login_background)
    ImageView lb;
    @BindView(mobile_img)
    ImageView mi;
    @BindView(otp_img)
    ImageView oi;
    @BindView(e_cell_logo)
    ImageView ecl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.iket.ecellapp2k17.fb",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }


        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_fb_login);

        ButterKnife.bind(this);
        Glide.with(this).load(R.drawable.login_bg).fitCenter().into(lb);
        Glide.with(this).load(R.drawable.user_black).fitCenter().into(mi);
        Glide.with(this).load(R.drawable.password_black).fitCenter().into(oi);
        Glide.with(this).load(R.drawable.ecell_logo).fitCenter().into(ecl);

        sharedPrefs = new SharedPrefs(this);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        //profile_pic = (ProfilePictureView) findViewById(R.id.picture);
        //imageView = (ImageView) findViewById(R.id.picture);
        callbackManager = CallbackManager.Factory.create();


        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                RequestData();
                Toast.makeText(getApplicationContext(),"Logged in Successfully !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(fb_login.this, Home.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

                Toast.makeText(getApplicationContext(),"Something went wrong !!",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void RequestData(){
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object,GraphResponse response) {

                JSONObject json = response.getJSONObject();
                try {
                    if(json != null){

                        String userName=json.getString("username");
                        profile_pic.setProfileId(json.getString("id"));
                        URL image_value= new URL("http://graph.facebook.com/" + userName + "/picture" );
                        sharedPrefs.setPhotoUrl(image_value.toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email,picture");
        request.setParameters(parameters);
        request.executeAsync();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
