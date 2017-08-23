package com.esummit.nitrr.ecellapp2k17.sponsors.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.esummit.nitrr.ecellapp2k17.R;
import com.esummit.nitrr.ecellapp2k17.helper.image_loaders.RoundedCornersTransformation;
import com.esummit.nitrr.ecellapp2k17.sponsors.model.RetrofitSponsProvider;
import com.esummit.nitrr.ecellapp2k17.sponsors.model.data.SponsHeading;
import com.esummit.nitrr.ecellapp2k17.sponsors.model.data.SponsData;
import com.esummit.nitrr.ecellapp2k17.sponsors.presenter.SponsPresenter;
import com.esummit.nitrr.ecellapp2k17.sponsors.presenter.SponsPresenterImpl;
import com.esummit.nitrr.ecellapp2k17.sponsors.view.viewholder.HeaderViewHolder;
import com.esummit.nitrr.ecellapp2k17.sponsors.view.viewholder.SponsItemViewholder;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SponsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SponsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SponsFragment extends Fragment implements SponsInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    GridLayoutManager glm;
    ProgressBar progressBar;
    private CardView card_default_spons;

    private SponsPresenter sponsPresenter;
    private SectionedRecyclerViewAdapter sectionAdapter;

    Dialog dialog;

    private OnFragmentInteractionListener mListener;
    public SponsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SponsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SponsFragment newInstance(String param1, String param2) {
        SponsFragment fragment = new SponsFragment();
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
        View view= inflater.inflate(R.layout.fragment_spons, container, false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view_spons);
        progressBar= (ProgressBar) view.findViewById(R.id.progressBar_spons);
        card_default_spons = (CardView) view.findViewById(R.id.card_coming_soon_spons);
//        sponsPresenter=new SponsPresenterImpl(this,new MockSpons());

        sponsPresenter=new SponsPresenterImpl(this,new RetrofitSponsProvider());
        sectionAdapter = new SectionedRecyclerViewAdapter();

        glm = new GridLayoutManager(getContext(), 2);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(sectionAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(sectionAdapter);
        sponsPresenter.requestSpons();
        return view;
    }

    @Override
    public void showDefault(boolean show) {
        if (show){
            card_default_spons.setVisibility(View.VISIBLE);
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

                    sponsPresenter=new SponsPresenterImpl(SponsFragment.this,new RetrofitSponsProvider());
                    sponsPresenter.requestSpons();
                    dialog.dismiss();
                }
            });
        }
    }*/

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
    @Override
    public void showLoading(boolean show) {
        if(show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<SponsHeading> sponsDataList) {

        try{
            for(int i=0;i<sponsDataList.size();i++) {
                sectionAdapter.addSection(new SponsSection(sponsDataList.get(i).getSection_name(), sponsDataList.get(i).getSponsors()));
            }
        }
        catch (Exception e){
            Toast.makeText(getContext(),"Coming Soon !!",Toast.LENGTH_LONG).show();
        }
            sectionAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
    }



    private class SponsSection extends StatelessSection {
        String title;
        List<SponsData> list;

        SponsSection(String title, List<SponsData> list) {
            super(new SectionParameters.Builder(R.layout.spons_item)
                    .headerResourceId(R.layout.section_spons)
                    .build());

            this.title = title;
            this.list = list;
        }

        @Override
        public int getContentItemsTotal() {
            return list.size();
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new SponsItemViewholder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final SponsItemViewholder itemHolder = (SponsItemViewholder) holder;

            String name = list.get(position).getSponsName();
            String image=list.get(position).getImage1();
            itemHolder.spons_name.setText(name);
            Glide.with(getContext()).load(image).bitmapTransform(new RoundedCornersTransformation(getContext(),16,0))
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            itemHolder.progressBar2.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            itemHolder.progressBar2.setVisibility(View.GONE);
                            return false;
                        }
                    }).into(itemHolder.imageView);
            itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(getContext(), String.format("Clicked on position #%s of Section %s",
//                            sectionAdapter.getPositionInSection(itemHolder.getAdapterPosition()), title),
//                            Toast.LENGTH_SHORT).show();
                    FragmentManager fm = getFragmentManager();
                    SponsEndPage_Fragment sponsEndPage_fragment=new SponsEndPage_Fragment();
                    sponsEndPage_fragment.setData(list.get(position));
                    sponsEndPage_fragment.show(fm,"Sponsor_details");
                    Log.d("Spons",""+list.get(position).getWebsite_url());
 //                   ((Home)getContext()).addFragment(sponsEndPage_fragment);
                }
            });
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.sponsTitle.setText(title);
        }
    }
}
