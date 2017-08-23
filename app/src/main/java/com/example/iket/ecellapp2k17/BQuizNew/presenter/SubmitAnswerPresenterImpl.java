package com.example.iket.ecellapp2k17.BQuizNew.presenter;

import android.util.Log;

import com.example.iket.ecellapp2k17.BQuizNew.model.SubmitAnswerProvider;
import com.example.iket.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;
import com.example.iket.ecellapp2k17.BQuizNew.view.BQuizView;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.annotations.Experimental;


public class SubmitAnswerPresenterImpl implements SubmitAnswerPresenter {

    BQuizView bQuizView;
    SubmitAnswerProvider submitAnswerProvider;

    public SubmitAnswerPresenterImpl(BQuizView bQuizView, SubmitAnswerProvider submitAnswerProvider) {
        this.bQuizView = bQuizView;
        this.submitAnswerProvider = submitAnswerProvider;
    }

    @Override
    public void submitAnswer(int questionId, String answer, String accessToken) {
        if(answer.isEmpty())
            answer="null";
        bQuizView.showProgressbar(true);
        Observable<SubmitAnswerData> submitAnswerDataObservable =
                submitAnswerProvider.submitQuestion(questionId, answer, accessToken);

        submitAnswerDataObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SubmitAnswerData>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(SubmitAnswerData submitAnswerData) {
                        bQuizView.showProgressbar(false);
                        if (submitAnswerData.isSuccess()) {
                            bQuizView.answerSubmitted(submitAnswerData);
                        } else {
                            bQuizView.showMessage(submitAnswerData.getMessage_display());
                        }
                    }
                });

    }
}
