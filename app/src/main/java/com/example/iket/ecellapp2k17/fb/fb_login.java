package com.example.iket.ecellapp2k17.fb;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.Home;
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

import static com.example.iket.ecellapp2k17.R.id.picture;

public class fb_login extends AppCompatActivity {

    CallbackManager callbackManager;
    LoginButton loginButton;
    ImageView imageView;
    ProfilePictureView profile_pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_fb_login);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        profile_pic = (ProfilePictureView) findViewById(R.id.picture);
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

                        profile_pic.setProfileId(json.getString("id"));
                     //Glide.with(fb_login.this).load( "http://graph.facebook.com/"+json.getString("id")+"/picture?type=small").into(imageView);

                    }

                } catch (JSONException e) {
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
