package com.example.iket.ecellapp2k17.sponsors.model.data;

import java.util.List;

/**
 * Created by samveg on 23/6/17.
 */

public class SponsHeading {

    private List<SponsData> spons;
    private String section_name;

    public SponsHeading(List<SponsData> spons, String section_name) {
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
