package com.example.iket.ecellapp2k17.about_us.model.data;

import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class TeamList {
    private List<TeamData> aboutus;
    private boolean success;
    private String message;

    public TeamList(List<TeamData> aboutus) {
        this.aboutus = aboutus;
    }

    public List<TeamData> getTeam(){
        return aboutus;
    }
}
