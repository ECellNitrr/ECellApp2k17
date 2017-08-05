package com.example.iket.ecellapp2k17.otp_verify.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.helper.Keys;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.home.Home;
import com.example.iket.ecellapp2k17.login.presenter.LoginData;
import com.example.iket.ecellapp2k17.login.presenter.LoginDataImp;
import com.example.iket.ecellapp2k17.login.provider.RetrofitLoginHelper;
import com.example.iket.ecellapp2k17.login.view.LoginActivity;
import com.example.iket.ecellapp2k17.otp_verify.model.OtpData;
import com.example.iket.ecellapp2k17.otp_verify.presenter.OtpVerifyPresenter;
import com.example.iket.ecellapp2k17.otp_verify.presenter.OtpVerifyPresenterImp;
import com.example.iket.ecellapp2k17.otp_verify.provider.RetrofitOtpVerifyHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.iket.ecellapp2k17.R.id.e_cell_logo;
import static com.example.iket.ecellapp2k17.R.id.login_background;
import static com.example.iket.ecellapp2k17.R.id.mobile_img;
import static com.example.iket.ecellapp2k17.R.id.otp_img;

public class OtpActivity extends AppCompatActivity implements OtpView{

    private Button button;
    private Button button2;
    private Button button3;
    private LoginData loginData;
    private EditText editTextOtp;
    private ProgressBar progressBar;
    private ImageView otpImage;
    private String message, otp_number;
    private OtpVerifyPresenter otpVerifyPresenter;
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
        setContentView(R.layout.activity_fb_login);
        ButterKnife.bind(this);
        Glide.with(this).load(R.drawable.login_bg).into(lb);
        Glide.with(this).load(R.drawable.user_black).into(mi);
        Glide.with(this).load(R.drawable.password_black).into(oi);
        Glide.with(this).load(R.drawable.ecell_logo).into(ecl);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            message = bundle.getString(Keys.KEY_MOBILE);
        }
        sharedPrefs = new SharedPrefs(this);
        editTextOtp = (EditText) findViewById(R.id.input_otp);
        button = (Button) findViewById(R.id.otpIn);
        button2 = (Button) findViewById(R.id.logIn);
        button3 = (Button) findViewById(R.id.resend_otp);
        otpImage = (ImageView) findViewById(R.id.otp_img);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        otpImage.setVisibility(View.VISIBLE);
        editTextOtp.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.VISIBLE);
    }

    public void proceed_verify(View v) {
        otp_number = editTextOtp.getText().toString();
        otpVerifyPresenter = new OtpVerifyPresenterImp(this, new RetrofitOtpVerifyHelper());
        otpVerifyPresenter.otpData(otp_number, message);
    }
    public void resend(View v) {

        LoginActivity loginActivity = new LoginActivity();
        loginActivity.proceed(v);
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void OtpStatus(OtpData otpData) {

        Intent i = new Intent(this, Home.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        sharedPrefs.setAccessToken(otpData.getAccess_token());
        sharedPrefs.setLogin(true);
        finish();


    }

    @Override
    protected void onDestroy() {
        if(otpVerifyPresenter!=null){
            otpVerifyPresenter.onDestroy();
        }
        super.onDestroy();

    }
}
