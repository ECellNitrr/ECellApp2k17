package com.bquiz.raipur.ecellapp2k17.BQuizNew.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.RetrofitBquizProvider;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.RetrofitSubmitAnswerProvider;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data.BQuizData;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter.BQuizPresenter;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter.BQuizPresenterImpl;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter.SubmitAnswerPresenter;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter.SubmitAnswerPresenterImpl;
import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.helper.SharedPrefs;
import com.bquiz.raipur.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.bquiz.raipur.ecellapp2k17.helper.image_loaders.ImageLoader;

import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BQuizActivity extends AppCompatActivity implements BQuizView {

    @BindView(R.id.question_text)
    TextView question_text;

    @BindView(R.id.question_image)
    ImageView question_image;

    @BindView(R.id.bquiz_answer)
    EditText input_ans;

    @BindView(R.id.question_image_text)
    TextView question_image_text;

    @BindView(R.id.bquiz_submit)
    Button submit_button;

    @BindView(R.id.bquiz_progressbar)
    ProgressBar progressbar;

    @BindView(R.id.bquiz_title)
    TextView message;

    @BindView(R.id.bquiz_timer)
    TextView timer;

    @BindView(R.id.image_layout)
    ScrollView image_layout;

    @BindView(R.id.status_layout)
    RelativeLayout status_layout;

    @BindView(R.id.status_image)
    ImageView status_image;

    @BindView(R.id.text_layout)
    ScrollView text_layout;

    int time,i=0;
    private BQuizPresenter bQuizPresenter;
    private ImageLoader imageLoader;
    private SubmitAnswerPresenter submitAnswerPresenter;
    private int questionId;
    private int data_type;
    private CountDownTimer countDownTimer;
    SharedPrefs sharedPrefs;
    Dialog dialog;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bquiz__intro);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
//        bQuizPresenter = new BQuizPresenterImpl(this, new MockBquizProvider());
        bQuizPresenter = new BQuizPresenterImpl(this, new RetrofitBquizProvider());
        sharedPrefs = new SharedPrefs(BQuizActivity.this);
        bQuizPresenter.getBquizData(sharedPrefs.getAccessToken());

        submitAnswerPresenter = new SubmitAnswerPresenterImpl(this, new RetrofitSubmitAnswerProvider());
        imageLoader = new GlideImageLoader(this);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                submitAnswerPresenter.submitAnswer(questionId, getAnswer(), sharedPrefs.getAccessToken());

            }
        });
    }

    @Override
    public void onBackPressed() {

        if(i==0)
            super.onBackPressed();
        if(i==1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("If you exit,your empty response will be submitted.\n Still want to Exit? ")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            submitAnswerPresenter.submitAnswer(questionId, getAnswer(), sharedPrefs.getAccessToken());
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        bQuizPresenter.cancelCall();
        try {
            dialog.dismiss();
        }
        catch (Exception e)
        {
            Log.d("BQUIZ",""+e);
        }

    }

    @Override
    protected void onStop()
    {
        bQuizPresenter.cancelCall();
        super.onStop();
        try {
            countDownTimer.cancel();
        }
        catch (Exception e)
        {
            Log.d("BQUIZ",""+e);
        }
        try {
            dialog.dismiss();
        }
        catch (Exception e)
        {
            Log.d("BQUIZ",""+e);
        }
        if(i==1)
        {
//            submitAnswerPresenter.submitAnswer(questionId, getAnswer(), sharedPrefs.getAccessToken());
            i=0;
        }
    }

    @Override
    public void showMessage(String message_text) {
        message.setText(message_text);
        Toast.makeText(BQuizActivity.this, message_text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressbar(boolean show) {
        if (show)
            progressbar.setVisibility(View.VISIBLE);
        else
            progressbar.setVisibility(View.GONE);
    }

    @Override
    public void setBquizData(final BQuizData bquizData) {

        i=1;

            questionId = bquizData.getQuestion_data().getQuestion_id();
            data_type = bquizData.getData_type();
            dialog = new Dialog(BQuizActivity.this);
            dialog.setContentView(R.layout.activity_rules__dialog_box);
            Button btn = (Button) dialog.findViewById(R.id.dialog_button);
            TextView rules5 = (TextView) dialog.findViewById(R.id.rules5);
            rules5.setText(bquizData.getRules());
            dialog.setTitle("Rules");
            dialog.setCancelable(false);
            dialog.show();
            switch (data_type) {
                case 1:
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            i=1;
                            image_layout.setVisibility(View.GONE);
                            status_layout.setVisibility(View.GONE);
                            timer.setVisibility(View.VISIBLE);
                            input_ans.setVisibility(View.VISIBLE);
                            submit_button.setVisibility(View.VISIBLE);
                            submit_button.setClickable(true);
                            text_layout.setVisibility(View.VISIBLE);
                            question_text.setText(bquizData.getQuestion_data().getQuestion());
                            time = bquizData.getQuestion_data().getQuestion_duration();
                            countDown(time);
                            dialog.dismiss();
                        }
                    });
                    break;
                case 2:
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            text_layout.setVisibility(View.GONE);
                            image_layout.setVisibility(View.VISIBLE);
                            status_layout.setVisibility(View.GONE);
                            timer.setVisibility(View.VISIBLE);
                            input_ans.setVisibility(View.VISIBLE);
                            submit_button.setVisibility(View.VISIBLE);
                            submit_button.setClickable(true);

                            i=1;
                            question_image_text.setText(bquizData.getQuestion_data().getQuestion());
                            time = bquizData.getQuestion_data().getQuestion_duration();

                            Glide.with(BQuizActivity.this)
                                    .load(bquizData.getQuestion_data().getImage_url())
                                    .listener(new RequestListener<String, GlideDrawable>() {
                                        @Override
                                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                            if(e instanceof UnknownHostException)
                                                Glide.clear(question_image);
                                            return false;
                                        }

                                        @Override
                                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                            countDown(time);
                                            return false;
                                        }
                                    })
                                    .into(question_image);
                            dialog.dismiss();
                        }
                    });
                    break;
                default:
                    setBquizInactive(bquizData.getMessage_image_url());
            }
        }

    @Override
    public void setBquizInactive(String message_image) {
        text_layout.setVisibility(View.GONE);
        image_layout.setVisibility(View.GONE);
        timer.setVisibility(View.GONE);
        input_ans.setVisibility(View.INVISIBLE);
        submit_button.setVisibility(View.INVISIBLE);
        submit_button.setClickable(false);
        imageLoader.loadImage(message_image,status_image);

    }

    @Override
    public void answerSubmitted(SubmitAnswerData submitAnswerData) {
        if (submitAnswerData.isSuccess()) {
            Toast.makeText(this, "Answer Submitted", Toast.LENGTH_SHORT).show();
            finish();
//            setMessageLayout(submitAnswerData.getMessage_image(),submitAnswerData.getMessage_display());
        }
        else
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();

    }

    public void countDown(int time) {
        time *= 1000;
           countDownTimer=new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText(""+millisUntilFinished / 60000 + " : " + (millisUntilFinished / 1000) % 60);
            }

            public void onFinish() {
                submitAnswerPresenter.submitAnswer(questionId, getAnswer(), sharedPrefs.getAccessToken());
//                i=0;
                countDownTimer.cancel();
            }
        }.start();
    }

    private String getAnswer() {
        return input_ans.getText().toString();
    }
}
