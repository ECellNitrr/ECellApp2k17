package com.example.iket.ecellapp2k17.sponsors.view;

import com.example.iket.ecellapp2k17.sponsors.model.data.SponsHeading;

import java.util.List;

/**
 * Created by samveg on 23/6/17.
 */

public interface SponsInterface {
    void showLoading(boolean show);
    void showMessage(String message);
    void setData(List<SponsHeading> sponsDataList);
}
