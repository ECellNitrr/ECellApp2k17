package com.example.iket.ecellapp2k17.events.presenter;

import android.os.CountDownTimer;
import android.util.Log;

import com.example.iket.ecellapp2k17.events.model.EventsProvider;
import com.example.iket.ecellapp2k17.events.view.EventsInterface;
import com.example.iket.ecellapp2k17.events.view.OnEventsReceived;

/**
 * Created by vrihas on 7/6/17.
 */

public class EventPresenterImpl implements EventsPresenter {

    private EventsProvider eventsProvider;
    private EventsInterface eventsInterface;
    CountDownTimer countDownTimer;

    public EventPresenterImpl(EventsInterface eventsInterface,EventsProvider eventsProvider){
        this.eventsInterface = eventsInterface;
        this.eventsProvider = eventsProvider;
    }

    @Override
    public void requestEvents() {
        Log.d("ResponseOtp","4");
        countDownTimer = new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                eventsInterface.showMessage( "Slow internet connection..");
            }
        }.start();

      /*  eventsProvider.requestEvents(new OnEventsReceived(){

        }
        */

    }
}
