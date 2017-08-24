package com.bquiz.raipur.ecellapp2k17.about_us.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bquiz.raipur.ecellapp2k17.helper.image_loaders.GlideImageLoader;
import com.bquiz.raipur.ecellapp2k17.helper.image_loaders.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.about_us.model.RetrofitProviderTeam;
import com.bquiz.raipur.ecellapp2k17.about_us.model.data.TeamData;
import com.bquiz.raipur.ecellapp2k17.about_us.presenter.AboutUsPresenter;
import com.bquiz.raipur.ecellapp2k17.about_us.presenter.AboutUsPresenterImpl;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeamFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamFragment extends Fragment  implements AboutUsInterface{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    private ImageView faculty_image,faculty_research_img;
    private RecyclerAdapter recyclerAdapter;
    private GridLayoutManager gridLayoutManager;
    private ImageLoader imageLoader;

    private AVLoadingIndicatorView progressBar2,progressBar3;

    private ProgressBar progressBar;

    AboutUsPresenter aboutUsPresenter;

    Dialog dialog;

    private OnFragmentInteractionListener mListener;

    public TeamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamFragment newInstance(String param1, String param2) {
        TeamFragment fragment = new TeamFragment();
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
        View view= inflater.inflate(R.layout.fragment_team, container, false);
        faculty_image = (ImageView) view.findViewById(R.id.facultyImg);
        faculty_research_img = (ImageView) view.findViewById(R.id.faculty_researchImg);
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view_team);
        imageLoader=new GlideImageLoader(getContext());
        progressBar2 = (AVLoadingIndicatorView) view.findViewById(R.id.progressBar_faculty);
        progressBar3 = (AVLoadingIndicatorView) view.findViewById(R.id.progressBar_faculty_research);
        recyclerView.setHasFixedSize(true);
        progressBar=(ProgressBar)view.findViewById(R.id.team_progressbar);

        gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerAdapter=new RecyclerAdapter(getContext());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        imageLoader.load_circular_image("https://ecell.nitrr.ac.in/images/incharge.jpg",faculty_image,progressBar2);
        imageLoader.load_circular_image("https://ecell.nitrr.ac.in/images/sanyal_dean.jpg",faculty_research_img,progressBar3);

 //       aboutUsPresenter =new AboutUsPresenterImpl(new MockAboutUs(),this);
        aboutUsPresenter=new AboutUsPresenterImpl(new RetrofitProviderTeam(),this);
//        aboutUsPresenter =new AboutUsPresenterImpl(new MockAboutUs(),this);
        aboutUsPresenter.requestData();

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
    public void setData(List<TeamData> teamDataList) {
        recyclerAdapter.setData(teamDataList);
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

   /* @Override
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

                    aboutUsPresenter=new AboutUsPresenterImpl(new RetrofitProviderTeam(),TeamFragment.this);
                    aboutUsPresenter.requestData();
                    dialog.dismiss();
                }
            });
        }
    }*/

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
