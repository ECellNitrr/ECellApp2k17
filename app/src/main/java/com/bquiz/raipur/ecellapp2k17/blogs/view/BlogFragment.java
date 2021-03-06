package com.bquiz.raipur.ecellapp2k17.blogs.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.blogs.model.RetrofitBlogsProvider;
import com.bquiz.raipur.ecellapp2k17.blogs.model.data.BlogFeed;
import com.bquiz.raipur.ecellapp2k17.blogs.presenter.BlogsPresenter;
import com.bquiz.raipur.ecellapp2k17.blogs.presenter.BlogsPresenterImpl;
import com.bquiz.raipur.ecellapp2k17.helper.VerticalViewPager;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogFragment extends Fragment implements BlogsInterface {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    VerticalViewPager verticalViewPager;
    VerticlePagerAdapter verticlePagerAdapter;
    BlogsPresenter blogsPresenter;
    private ProgressBar progressBar;
    private CardView card_default_blogs;

    private FloatingActionButton fab;
    private CoordinatorLayout layout;

    Dialog dialog;
    private OnFragmentInteractionListener mListener;

    public BlogFragment() {
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
    public static BlogFragment newInstance(String param1, String param2) {
        BlogFragment fragment = new BlogFragment();
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
        View view= inflater.inflate(R.layout.fragment_blog, container, false);




        layout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout_blog);
        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                DialogFragment newFragment = AddABlog.newInstance("","");
                newFragment.show(ft, "dialog");
            }
        });
        card_default_blogs = (CardView) view.findViewById(R.id.card_coming_soon_blogs);
        progressBar=(ProgressBar)view.findViewById(R.id.blogs_progress_bar);
        verticalViewPager=(VerticalViewPager)view.findViewById(R.id.blogs_viewPager);
        verticlePagerAdapter=new VerticlePagerAdapter(getContext());
        verticalViewPager.setAdapter(verticlePagerAdapter);
        blogsPresenter=new BlogsPresenterImpl(new RetrofitBlogsProvider(),this);
//          blogsPresenter=new BlogsPresenterImpl(new MockBlogs(),this);
        blogsPresenter.requestBlogs();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onStop() {
        super.onStop();

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
    public void setData(BlogFeed blogDataList) {
        verticlePagerAdapter.setBlogDataList(blogDataList.getBlogs());
        verticlePagerAdapter.notifyDataSetChanged();
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

    @Override
    public void showDefault(boolean show) {
        if (show){
            card_default_blogs.setVisibility(View.VISIBLE);
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

   /* public void checkNetwork()
    {
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

                        blogsPresenter=new BlogsPresenterImpl(new RetrofitBlogsProvider(),BlogFragment.this);
                        blogsPresenter.requestBlogs();
                        dialog.dismiss();
                }
            });
        }
    }*/

}
