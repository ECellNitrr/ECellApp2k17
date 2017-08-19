package com.example.iket.ecellapp2k17.sponsors.view;

import com.example.iket.ecellapp2k17.sponsors.model.data.SponsHeading;
import com.example.iket.ecellapp2k17.sponsors.model.data.SponsParent;

import java.util.List;

/**
 * Created by samveg on 23/6/17.
 */

public interface OnSponsReceived {
    void onFailure();
    void onSuccess(SponsParent sponsParent);
}

