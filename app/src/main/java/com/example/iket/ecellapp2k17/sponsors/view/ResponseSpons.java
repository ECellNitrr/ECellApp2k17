package com.example.iket.ecellapp2k17.sponsors.view;

import java.util.List;

/**
 * Created by samveg on 23/6/17.
 */

public class ResponseSpons {

    private List<SponsData> spons;

    public ResponseSpons(List<SponsData> spons) {
        this.spons = spons;
    }

    public List<SponsData> getSpons() {
        return spons;
    }

}
