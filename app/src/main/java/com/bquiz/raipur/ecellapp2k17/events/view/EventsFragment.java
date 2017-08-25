package com.bquiz.raipur.ecellapp2k17.events.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.events.model.RetrofitEventsProvider;
import com.bquiz.raipur.ecellapp2k17.events.model.data.EventsData;
import com.bquiz.raipur.ecellapp2k17.events.presenter.EventPresenterImpl;
import com.bquiz.raipur.ecellapp2k17.events.presenter.EventsPresenter;
//import com.facebook.shimmer.ShimmerFrameLayout;
import com.mikepenz.itemanimators.SlideDownAlphaAnimator;

import java.util.List;

/**
 * Created by vrihas on 16/6/17.
 */

public class EventsFragment extends Fragment implements EventsInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView event_recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private SwipeRefreshLayout swipeRefreshLayout;
    private EventsPresenter eventsPresenter;
    private EventsAdapter eventsAdapter;
    private ProgressBar progressBar;
    private CardView card_default_events;

    Dialog dialog;

    private EventsFragment.OnFragmentInteractionListener mListener;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
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
        View view= inflater.inflate(R.layout.fragment_events, container, false);
        progressBar=(ProgressBar)view.findViewById(R.id.events_progressbar);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout_events);
        card_default_events = (CardView) view.findViewById(R.id.card_coming_soon_events);
        event_recyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);
        event_recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(getContext());
        eventsAdapter = new EventsAdapter(getContext());

//        eventsPresenter=new EventPresenterImpl(this,new MockData());
        eventsPresenter=new EventPresenterImpl(this,new RetrofitEventsProvider());
        event_recyclerView.setLayoutManager(linearLayoutManager);
        event_recyclerView.setAdapter(eventsAdapter);
        event_recyclerView.setItemAnimator(new SlideDownAlphaAnimator());
        eventsPresenter.requestEvents();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                eventsPresenter=new EventPresenterImpl(EventsFragment.this,new RetrofitEventsProvider());
                eventsPresenter.requestEvents();
                swipeRefreshLayout.setRefreshing(false);
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

    @Override
    public void SetData(List<EventsData> eventDataList) {
        eventsAdapter.setData(eventDataList);
        eventsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Log.d("Events",message);
    }

    @Override
    public void ShowProgressBar(boolean show) {
        if(show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showDefault(boolean show) {
        if (show){
            card_default_events.setVisibility(View.VISIBLE);
        }
    }

    /*@Override
    public void checkNetwork() {
        if(!NetworkUtils.isNetworkAvailable(getContext())){
            dialog = new Dialog(getActivity());
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

                    eventsPresenter=new EventPresenterImpl(EventsFragment.this,new RetrofitEventsProvider());
                    eventsPresenter.requestEvents();
                    dialog.dismiss();
                }
            });
        }
    }*/

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
