package com.example.iket.ecellapp2k17.about_us.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
/*
    @BindView(R.id.vision_img)
    ImageView vision_chip;

    @BindView(R.id.contact_us_img)
    ImageView contact_us_chip;

    @BindView(R.id.team_img)
    ImageView team_chip;

    @BindView(R.id.past_work_img)
    ImageView past_work_chip;
*/
    @BindView(R.id.tabLayout_aboutus)
    TabLayout tabLayout;

    FragmentPagerAdapter adapterViewPager;

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
 //       Glide.with(getContext()).load(R.drawable.vision).bitmapTransform(new CropCircleTransformation(getContext())).into(vision_chip);
   //     Glide.with(getContext()).load(R.drawable.contact_us).bitmapTransform(new CropCircleTransformation(getContext())).into(contact_us_chip);
//        Glide.with(getContext()).load(R.drawable.past_work).bitmapTransform(new CropCircleTransformation(getContext())).into(past_work_chip);
 //       Glide.with(getContext()).load(R.drawable.team).bitmapTransform(new CropCircleTransformation(getContext())).into(team_chip);

 //       vision_chip.setPressed(true);
       /* FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.about_us_container,new VisionFragment());
        fragmentTransaction.commit();*/
        ViewPager vpPager = (ViewPager) view.findViewById(R.id.view_pager_aboutus);
        adapterViewPager = new PagerAdapter(getActivity().getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        tabLayout.setupWithViewPager(vpPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            //tab.setCustomView(adapterViewPager.getTabView(i));
        }
       // setupTabIcons();
/*
        team_chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.about_us_container,new TeamFragment());
                fragmentTransaction.commit();
                }
        });
        contact_us_chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.about_us_container,new ContactUsFragment());
                fragmentTransaction.commit();

                }
        });
        vision_chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.about_us_container,new VisionFragment());
                fragmentTransaction.commit();
                }
        });
*/
 /*       team_chip.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                team_chip.setPressed(true);
                vision_chip.setPressed(false);
                contact_us_chip.setPressed(false);
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.about_us_container,new TeamFragment());
                fragmentTransaction.commit();
                return true;
            }
        });

        vision_chip.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                vision_chip.setPressed(true);
                team_chip.setPressed(false);
                contact_us_chip.setPressed(false);
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.about_us_container,new VisionFragment());
                fragmentTransaction.commit();
                return true;
            }
        });

        contact_us_chip.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                team_chip.setPressed(false);
                vision_chip.setPressed(false);
                contact_us_chip.setPressed(true);
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.about_us_container,new ContactUsFragment());
                fragmentTransaction.commit();
                return true;
            }
        });
        */
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    /*    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
    }/*
    private void setupTabIcons() {
        View view1;
        for (int i = 0; i < tabIcons.length; i++) {
            view1 = getActivity().getLayoutInflater().inflate(R.layout.custom_tab, null);
            view1.findViewById(R.id.tab_icon).setBackgroundResource(tabIcons[i]);
            tabLayout.newTab().setCustomView(view1);
         //   tabLayout.addTab(tabLayout.newTab().setCustomView(view1));
        }
    }*/
}
