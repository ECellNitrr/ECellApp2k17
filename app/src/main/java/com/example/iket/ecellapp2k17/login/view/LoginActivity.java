package com.example.iket.ecellapp2k17.login.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.helper.Keys;
import com.example.iket.ecellapp2k17.helper.NetworkUtils;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.login.model.LoginDataResponse;
import com.example.iket.ecellapp2k17.login.presenter.LoginData;
import com.example.iket.ecellapp2k17.login.presenter.LoginDataImp;
import com.example.iket.ecellapp2k17.login.provider.RetrofitLoginHelper;
import com.example.iket.ecellapp2k17.otp_verify.view.OtpActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editTextMobile,editTextName,editTextEmail;
    private TextView msgOtp;
    private ProgressBar progressBar;
    public String mobile,name,email;
    private LoginData loginData;
    private ImageView ecell_logo,login_bg;
    private SharedPrefs sharedPrefs;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefs = new SharedPrefs(this);
        initialise();

    }

    public void initialise() {
        editTextMobile = (EditText) findViewById(R.id.input_mobile);
        editTextName = (EditText) findViewById(R.id.input_name);
        editTextEmail = (EditText) findViewById(R.id.input_email);
        msgOtp = (TextView) findViewById(R.id.otp_msg);
        ecell_logo = (ImageView) findViewById(R.id.e_cell_logo);
        login_bg = (ImageView) findViewById(R.id.login_background);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Glide.with(this).load(R.drawable.login_bg).into(login_bg);
        Glide.with(this).load(R.drawable.esummit).into(ecell_logo);
        editTextMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 10) {
                    hideKeyboard();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void proceed(View v) {
        name = editTextName.getText().toString();
        mobile = editTextMobile.getText().toString();
        email = editTextEmail.getText().toString();

        if (mobile.isEmpty() || name.isEmpty() || email.isEmpty()) {
            showProgressBar(false);
            showError("Fields cannot be empty");
        }
        else if(emailInvalid(email)){
            Toast.makeText(LoginActivity.this, "ENTER CORRECT EMAIL ID!",
                    Toast.LENGTH_LONG).show();
        }
        else {

            loginData = new LoginDataImp(this, new RetrofitLoginHelper());
            loginData.getLoginData(name,mobile,email);
            hideKeyboard();
        }

    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showLoginStatus(LoginDataResponse loginDataResponse) {
            msgOtp.setVisibility(View.VISIBLE);


            editTextName.setVisibility(View.GONE);
            editTextMobile.setVisibility(View.GONE);
            editTextEmail.setVisibility(View.GONE);
            Intent i = new Intent(LoginActivity.this, OtpActivity.class);
            i.putExtra(Keys.KEY_MOBILE, mobile);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            sharedPrefs.setMobile(mobile);
            sharedPrefs.setUsername(name);
            sharedPrefs.setEmailId(email);
            sharedPrefs.setAccessToken(loginDataResponse.getToken());
            finish();

    }

    @Override
    public void showError(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void checkNetwork() {
        if(!NetworkUtils.isNetworkAvailable(this)){
            dialog = new Dialog(this);
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

                    loginData = new LoginDataImp(LoginActivity.this, new RetrofitLoginHelper());
                    loginData.getLoginData(name,mobile,email);
                    dialog.dismiss();
                }
            });
        }
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
