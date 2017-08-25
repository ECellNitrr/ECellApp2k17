package com.bquiz.raipur.ecellapp2k17.BQuizNew.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.MockDataStatus;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.RetrofitStatusProvider;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter.BQuizFragmentPresenter;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter.BQuizFragmentPresenterImpl;
import com.bquiz.raipur.ecellapp2k17.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BQuizFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BQuizFragment extends Fragment implements BQuizFragmentView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.bquiz_image)
    ImageView bquiz_logo;
    @BindView(R.id.bquiz_details)
    TextView bquiz_description;
    @BindView(R.id.go_to_bquiz)
    Button go_to_bquiz;
    @BindView(R.id.progressBar_bquiz_image)
    AVLoadingIndicatorView progressBar;
    @BindView(R.id.comingsoon_text)
    TextView coming_soon_text;
    @BindView(R.id.swipe_layout_bquiz)
    SwipeRefreshLayout swipeRefreshLayout;

    private BQuizFragmentPresenter bQuizFragmentPresenter;

    private OnFragmentInteractionListener mListener;

    public BQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BQuizFragment newInstance(String param1, String param2) {
        BQuizFragment fragment = new BQuizFragment();
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
        View view = inflater.inflate(R.layout.fragment_bquiz,container,false);
        ButterKnife.bind(this,view);
//        bQuizFragmentPresenter = new BQuizFragmentPresenterImpl(BQuizFragment.this,new MockDataStatus());
        bQuizFragmentPresenter = new BQuizFragmentPresenterImpl(BQuizFragment.this,new RetrofitStatusProvider());
        bQuizFragmentPresenter.getBquizStatus();
        bquiz_description.setText("GET YOUR CORTEX FIXED CAUSE THIS QUIZ SPINS YOUR HEAD AROUND. LET'S EXPLORE SOME OF THE DE FACTO OF BUSINESS QUIZZING. GUIDE YOUR CEREBRUM'S WAY TO THIS B-QUIZ THAT WILL CATAPULT YOU INTO THE WORLD OF BUSINESS FACTS AND FIGURES.");
        Glide.with(getContext()).load("https://ecell.nitrr.ac.in/uploads/events/1502907861.png").listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(bquiz_logo);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bQuizFragmentPresenter = new BQuizFragmentPresenterImpl(BQuizFragment.this,new RetrofitStatusProvider());
                bQuizFragmentPresenter.getBquizStatus();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

        go_to_bquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bquiz=new Intent(getContext(), BQuizActivity.class);
                startActivity(bquiz);

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
    public void showPlayButton(boolean show) {

        if(show)
        {
            go_to_bquiz.setVisibility(View.VISIBLE);
            coming_soon_text.setVisibility(View.INVISIBLE);
        }
        else
        {
            go_to_bquiz.setVisibility(View.INVISIBLE);
            coming_soon_text.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
