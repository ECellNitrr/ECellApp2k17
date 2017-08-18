package com.example.iket.ecellapp2k17.login.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.helper.Keys;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.login.presenter.LoginData;
import com.example.iket.ecellapp2k17.login.presenter.LoginDataImp;
import com.example.iket.ecellapp2k17.login.provider.RetrofitLoginHelper;
import com.example.iket.ecellapp2k17.otp_verify.view.OtpActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editTextMobile,editTextName,editTextEmail;
    private ProgressBar progressBar;
    public String mobile,name,email;
    private LoginData loginData;
    private ImageView ecell_logo,login_bg;
    private SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefs = new SharedPrefs(this);
        initialise();
    }

    public void initialise() {
        editTextMobile = (EditText) findViewById(R.id.input_mobile);
        //editTextMobile.setGravity(Gravity.CENTER);
        editTextName = (EditText) findViewById(R.id.input_name);
        editTextEmail = (EditText) findViewById(R.id.input_email);
        ecell_logo = (ImageView) findViewById(R.id.e_cell_logo);
        login_bg = (ImageView) findViewById(R.id.login_background);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Glide.with(this).load(R.drawable.login_bg).into(login_bg);
        Glide.with(this).load(R.drawable.ecell_logo).into(ecell_logo);
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
    public void showLoginStatus(boolean login) {
        if (login) {

            sharedPrefs.setMobile(mobile);
            sharedPrefs.setUsername(name);
            sharedPrefs.setEmailId(email);
            editTextName.setVisibility(View.GONE);
            editTextMobile.setVisibility(View.GONE);
            editTextEmail.setVisibility(View.GONE);
            Intent i = new Intent(LoginActivity.this, OtpActivity.class);
            i.putExtra(Keys.KEY_NAME,name);
            i.putExtra(Keys.KEY_MOBILE, mobile);
            i.putExtra(Keys.KEY_EMAIL,email);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
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
