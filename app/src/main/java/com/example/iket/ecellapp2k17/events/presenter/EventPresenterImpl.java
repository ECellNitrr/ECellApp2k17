package com.example.iket.ecellapp2k17.events.presenter;

import android.os.CountDownTimer;
import android.util.Log;

import com.example.iket.ecellapp2k17.events.model.EventsProvider;
import com.example.iket.ecellapp2k17.events.model.data.EventsData;
import com.example.iket.ecellapp2k17.events.model.data.EventsList;
import com.example.iket.ecellapp2k17.events.view.EventsInterface;
import com.example.iket.ecellapp2k17.events.view.OnEventsReceived;

import java.util.List;

/**
 * Created by samveg on 21/6/17.
 */

public class EventPresenterImpl implements EventsPresenter {
    private EventsProvider eventsProvider;
    private EventsInterface eventsInterface;
    CountDownTimer countDownTimer;


    public EventPresenterImpl(EventsInterface eventsInterface, EventsProvider eventsProvider) {
        this.eventsInterface=eventsInterface;
        this.eventsProvider=eventsProvider;

    }

    @Override
    public void requestEvents() {
        Log.d("ResponseOtp","4");

        eventsInterface.ShowProgressBar(true);
        countDownTimer = new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                eventsInterface.showMessage( "Slow internet connection..");
            }
        }.start();

        eventsProvider.requestEvents(new OnEventsReceived() {
            @Override
            public void onSuccess(EventsList eventsList) {

                if (eventsList.isSuccess()){
                    countDownTimer.cancel();
                    eventsInterface.SetData(eventsList.getEvents());
                    eventsInterface.ShowProgressBar(false);
                    Log.d("ResponseOtp","Success");
                }
                else{
                    countDownTimer.cancel();
                    eventsInterface.showDefault(true);
                    eventsInterface.ShowProgressBar(false);
                }

            }

            @Override
            public void onFailure() {
                countDownTimer.cancel();
                eventsInterface.ShowProgressBar(false);
                eventsInterface.showMessage("No Internet Connection Available");
//                eventsInterface.checkNetwork();
            }
        });
    }
}

