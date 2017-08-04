package com.example.iket.ecellapp2k17.sponsors.model.data;

import com.example.iket.ecellapp2k17.sponsors.model.data.SponsData;

import java.util.List;

/**
 * Created by samveg on 23/6/17.
 */

public class ResponseSpons {

    private List<SponsData> spons;
    private String section_name;

    public ResponseSpons(List<SponsData> spons, String section_name) {
        this.spons = spons;
        this.section_name = section_name;
    }

    public List<SponsData> getSpons() {
        return spons;
    }

    public String getSection_name() {
        return section_name;
    }
}
