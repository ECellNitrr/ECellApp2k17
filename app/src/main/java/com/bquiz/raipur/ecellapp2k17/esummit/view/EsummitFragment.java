package com.bquiz.raipur.ecellapp2k17.esummit.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bquiz.raipur.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.bumptech.glide.Glide;
import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.esummit.model.RetrofitProviderSpeakers;
import com.bquiz.raipur.ecellapp2k17.esummit.model.data.SpeakerData;
import com.bquiz.raipur.ecellapp2k17.esummit.presenter.EsummitPresenter;
import com.bquiz.raipur.ecellapp2k17.esummit.presenter.EsummitPresenterImpl;
import com.bquiz.raipur.ecellapp2k17.helper.NetworkUtils;
import com.bquiz.raipur.ecellapp2k17.helper.TypewriterView;
import com.bquiz.raipur.ecellapp2k17.home.Home;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bquiz.raipur.ecellapp2k17.R.id.esummit_img;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EsummitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EsummitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EsummitFragment extends Fragment implements ViewInterface{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

//    @BindView(R.id.esummit_bg)
//    ImageView esummit_bg_img;

    @BindView(esummit_img)
    ImageView esummit_logo;

    @BindView(R.id.esummit_title)
    TextView esummit_title;
    @BindView(R.id.esummit_desc)
    TextView esummit_desc;

    @BindView(R.id.esummit_progressbar)
            ProgressBar progressBar;
    @BindView(R.id.swipe_layout_esummit)
    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recyclerView;
    private SpeakerAdapter recyclerAdapter;
    private CardView card_default_esummit;
    private LinearLayoutManager layoutManager;

    EsummitPresenter esummitPresenter;

    TypewriterView typewriterView;

    Dialog dialog;

    public EsummitFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EsummitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EsummitFragment newInstance(String param1, String param2) {
        EsummitFragment fragment = new EsummitFragment();
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
        View view = inflater.inflate(R.layout.fragment_esummit, container, false);
        Log.d("Hey","new frag");
        ButterKnife.bind(this,view);
        Glide.with(this).load(R.drawable.esummit).into(esummit_logo);
        card_default_esummit = (CardView) view.findViewById(R.id.card_coming_soon_esummit);
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view_speakers);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new SpeakerAdapter(getContext());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        esummitPresenter=new EsummitPresenterImpl(new RetrofitProviderSpeakers(),this);
//        esummitPresenter=new EsummitPresenterImpl(new MockSpeakers(),this);
        esummitPresenter.requestData();
        typewriterView = (TypewriterView) view.findViewById(R.id.type_writer_text);
        typewriterView.setVisibility(View.VISIBLE);
        setAnim();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                esummitPresenter=new EsummitPresenterImpl(new RetrofitProviderSpeakers(),EsummitFragment.this);
                esummitPresenter.requestData();
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

    public void setAnim()
    {

        typewriterView.setText("");
        typewriterView.setEnabled(false);
        typewriterView
                .type("A trek to the Zenith of Glory").pause()
                .delete("A trek to the Zenith of Glory").pause(500)
                .type("NIT Raipur!").pause(500)
                .delete("NIT Raipur!")
                .type("9th-10th September,2017").pause(1000)
                .delete("9th-10th September,2017").pause(500)
                .run(new Runnable() {
                    @Override
                    public void run() {
                        setAnim();
                    }
                });
    }

    @Override
    public void setData(List<SpeakerData> speakerDataList) {

        recyclerAdapter.setData(speakerDataList);
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDefault(boolean show) {
        if(show){
            card_default_esummit.setVisibility(View.VISIBLE);
        }
    }

    @Override
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

                    /*esummitPresenter=new EsummitPresenterImpl(new RetrofitProviderSpeakers(),EsummitFragment.this);
                    esummitPresenter.requestData();*/
                    Intent intent = new Intent(getActivity(),Home.class);
                    startActivity(intent);
                    getActivity().finish();
                    dialog.dismiss();
                }
            });
        }
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
