package com.example.iket.ecellapp2k17.sponsors.model.data;

import java.util.List;

/**
 * Created by samveg on 23/6/17.
 */

public class SponsHeading {

    private List<SponsData> sponsors;
    private String section_name;

    public SponsHeading(List<SponsData> sponsors, String section_name) {
        this.sponsors = sponsors;
        this.section_name = section_name;
    }

    public List<SponsData> getSponsors() {
        return sponsors;
    }

    public String getSection_name() {
        return section_name;
    }
}
