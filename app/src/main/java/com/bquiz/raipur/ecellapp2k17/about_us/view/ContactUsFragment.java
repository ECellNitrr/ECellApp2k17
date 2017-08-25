package com.bquiz.raipur.ecellapp2k17.about_us.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.about_us.model.RetrofitProviderContactUs;
import com.bquiz.raipur.ecellapp2k17.about_us.presenter.ContactUsPresenter;
import com.bquiz.raipur.ecellapp2k17.about_us.presenter.ContactUsPresenterImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactUsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactUsFragment extends Fragment implements ContactUsView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ContactUsPresenter contactUsPresenter;

    private EditText user_name,user_email,user_msg;
    private Button send_msg;
    private Context context;
    private ProgressBar progressBar_contactus;
    private String name,email,body;

    private OnFragmentInteractionListener mListener;

    Dialog dialog;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactUsFragment newInstance(String param1, String param2) {
        ContactUsFragment fragment = new ContactUsFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact_us,container,false);
        context = getContext();
        user_name = (EditText) view.findViewById(R.id.etxt_name);
        user_email = (EditText)view.findViewById(R.id.etxt_email);
        user_msg = (EditText)view.findViewById(R.id.etxt_msg);
        send_msg = (Button) view.findViewById(R.id.btn_send);
        progressBar_contactus = (ProgressBar) view.findViewById(R.id.progBar);

        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = user_name.getText().toString();
                email = user_email.getText().toString();
                body = user_msg.getText().toString();
                if (name.isEmpty() || email.isEmpty() || body.isEmpty()){
                    showProgressBar(false);
                    showError("Fields cannot be empty");
                }
                else if (emailInvalid(email)){
                    Toast.makeText(getContext(), "ENTER CORRECT EMAIL ID!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    contactUsPresenter = new ContactUsPresenterImpl(ContactUsFragment.this,new RetrofitProviderContactUs());
                    contactUsPresenter.getContactData(name,email,body);
                }
            }
        });

        return view;
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show){
            progressBar_contactus.setVisibility(View.VISIBLE);
        }else {
            progressBar_contactus.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showStatus(boolean status) {
        if (status){
            user_name.setText("");
            user_msg.setText("");
            user_email.setText("");
            Toast.makeText(getContext(),"Your Message has been sent successfully !",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
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

                    contactUsPresenter = new ContactUsPresenterImpl(ContactUsFragment.this,new RetrofitProviderContactUs());
                    contactUsPresenter.getContactData(name,email,body);
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

    public boolean emailInvalid(String email) {
        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        boolean a = matcher.matches();
        return !a;
    }

}
