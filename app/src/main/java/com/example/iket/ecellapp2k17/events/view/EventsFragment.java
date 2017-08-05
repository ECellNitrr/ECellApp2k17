package com.example.iket.ecellapp2k17.events.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.events.model.MockData;
import com.example.iket.ecellapp2k17.events.model.data.EventsData;
import com.example.iket.ecellapp2k17.events.presenter.EventPresenterImpl;
import com.example.iket.ecellapp2k17.events.presenter.EventsPresenter;
import com.example.iket.ecellapp2k17.helper.VerticalViewPager;

import java.util.List;

/**
 * Created by samveg on 16/6/17.
 */

public class EventsFragment extends Fragment implements EventsInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    VerticalViewPager verticalViewPager;
    private TextView[] dots;
    private LinearLayout dotsLayout;
    private EventsPresenter eventsPresenter;
    private ProgressBar progressBar;
    private VerticlePagerAdapter verticlePagerAdapter;

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
        dotsLayout=(LinearLayout)view.findViewById(R.id.events_dots);


        verticlePagerAdapter=new VerticlePagerAdapter(getContext());
        verticalViewPager=(VerticalViewPager)view.findViewById(R.id.events_viewPager);
        verticalViewPager.setAdapter(verticlePagerAdapter);
        addBottomDots(0);
        eventsPresenter=new EventPresenterImpl(this,new MockData());
        eventsPresenter.requestEvents();
        VerticalViewPager.OnPageChangeListener viewPagerPageChangeListener = new VerticalViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        };
        verticalViewPager.addOnPageChangeListener(viewPagerPageChangeListener);

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

    private void addBottomDots(int currentPage) {
        dots = new TextView[4];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            //    dots[i].setTextColor(Color.WHITE);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0)
            //          dots[currentPage].setTextColor(ContextCompat.getColor(this,R.color.white));
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    @Override
    public void SetData(List<EventsData> eventDataList) {
        verticlePagerAdapter.setData(eventDataList);
        verticlePagerAdapter.notifyDataSetChanged();
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
