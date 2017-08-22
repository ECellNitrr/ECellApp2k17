package com.example.iket.ecellapp2k17.about_us.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.iket.ecellapp2k17.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AboutUsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AboutUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutUsFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.tabLayout_aboutus)
    TabLayout tabLayout;
    ViewPager viewPager;
    private ImageView tab_icon_img;

    private int[] tabIcons = {R.drawable.vision_ic,R.drawable.team_ic,R.drawable.contact_us_ic};

    private OnFragmentInteractionListener mListener;
    public AboutUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutUsFragment newInstance(String param1, String param2) {
        AboutUsFragment fragment = new AboutUsFragment();
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
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this,view);
        viewPager = (ViewPager) view.findViewById(R.id.about_us_viewpager);

        //Creating our pager adapter
        TabsPagerAdapter adapter = new TabsPagerAdapter(getChildFragmentManager());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        adapter.addFragment(new VisionFragment());
        adapter.addFragment(new TeamFragment());
        adapter.addFragment(new ContactUsFragment());
        adapter.notifyDataSetChanged();
       // tabLayout.getTabAt(0).setIcon(tabIcons[0]);

       setupTabIcons();
    /*    FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.about_us_container,new VisionFragment());
        fragmentTransaction.commit();*/
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
/*        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i=tabLayout.getSelectedTabPosition();
                switch (i)
                {
                    case 0:
                        FragmentManager fragmentManager = getChildFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.about_us_container,new VisionFragment());
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        FragmentManager fragmentManager2 = getChildFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.about_us_container,new TeamFragment());
                        fragmentTransaction2.commit();
                        break;
                    case 2:
                        FragmentManager fragmentManager3 = getChildFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        fragmentTransaction3.replace(R.id.about_us_container,new ContactUsFragment());
                        fragmentTransaction3.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
*/
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void setupTabIcons() {
        View view1;
        for (int i = 0; i < tabIcons.length; i++) {
            view1 = getActivity().getLayoutInflater().inflate(R.layout.custom_tab, null);
            tab_icon_img = (ImageView) view1.findViewById(R.id.tab_icon);

       //     view1.findViewById(R.id.tab_icon).setBackgroundResource(tabIcons[i]);
       //     tabLayout.getTabAt(i).setCustomView(view1);

            Glide.with(this).load(tabIcons[i]).into(tab_icon_img);

        }

    }


}
