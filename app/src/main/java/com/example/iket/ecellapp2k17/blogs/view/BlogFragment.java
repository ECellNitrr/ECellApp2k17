package com.example.iket.ecellapp2k17.blogs.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.blogs.model.BlogsProvider;
import com.example.iket.ecellapp2k17.blogs.model.MockBlogs;
import com.example.iket.ecellapp2k17.blogs.model.RetrofitBlogsProvider;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.example.iket.ecellapp2k17.blogs.presenter.BlogsPresenter;
import com.example.iket.ecellapp2k17.blogs.presenter.BlogsPresenterImpl;
import com.example.iket.ecellapp2k17.helper.VerticalViewPager;
import com.example.iket.ecellapp2k17.home.Home;

import java.util.List;

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
    private NavigationView navigationView;
    VerticalViewPager verticalViewPager;
    VerticlePagerAdapter verticlePagerAdapter;
    BlogsPresenter blogsPresenter;
    private FloatingActionButton fab;
    private OnFragmentInteractionListener mListener;
    private FragmentManager fm = getFragmentManager();
    private Context context;

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


      //  navigationView = (NavigationView) view.findViewById(R.id.nav_view);

        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //addFragment(new AddABlog(),"Add A Blog",16);
                //AddABlog addABlog = new AddABlog();
                //addABlog.show(fm,"Add A Blog");
                FragmentManager fm = getFragmentManager();
                AddABlog addABlog = new AddABlog();
                addABlog.show(fm,"Add A Blog");


            }
        });


        verticalViewPager=(VerticalViewPager)view.findViewById(R.id.blogs_viewPager);
        verticlePagerAdapter=new VerticlePagerAdapter(getContext());
        verticalViewPager.setAdapter(verticlePagerAdapter);
//        blogsPresenter=new BlogsPresenterImpl(new RetrofitBlogsProvider(),this);
        blogsPresenter=new BlogsPresenterImpl(new MockBlogs(),this);
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
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setData(List<BlogData> blogDataList) {
        verticlePagerAdapter.setBlogDataList(blogDataList);
        verticlePagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void ShowProgressBar(boolean show) {

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

    public void open_blog(View view){

    }

}
