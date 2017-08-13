package com.example.iket.ecellapp2k17.about_us.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.about_us.model.MockAboutUs;
import com.example.iket.ecellapp2k17.about_us.model.data.AboutUsData;
import com.example.iket.ecellapp2k17.about_us.presenter.AboutUsPresenter;
import com.example.iket.ecellapp2k17.about_us.presenter.AboutUsPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static com.example.iket.ecellapp2k17.R.id.vision_body;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VisionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VisionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView vision_Body;
  //  AboutUsPresenter aboutUsPresenter;
    private List<AboutUsData> data=new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public VisionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VisionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisionFragment newInstance(String param1, String param2) {
        VisionFragment fragment = new VisionFragment();
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
        View view = inflater.inflate(R.layout.fragment_vision, container, false);
        vision_Body = (TextView) view.findViewById(vision_body);
/*
        aboutUsPresenter =new AboutUsPresenterImpl(new MockAboutUs(),this);
        aboutUsPresenter.requestData();
        AboutUsData listData =  data.get(5);
        vision_Body.setText(listData.getVisionBody());
*/
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
