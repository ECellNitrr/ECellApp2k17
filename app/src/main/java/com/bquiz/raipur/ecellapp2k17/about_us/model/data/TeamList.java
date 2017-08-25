package com.bquiz.raipur.ecellapp2k17.about_us.model.data;

import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class TeamList {
    private List<TeamData> team_members;
    private boolean success;
    private String message;

    public TeamList(List<TeamData> team_members, boolean success, String message) {
        this.team_members = team_members;
        this.success = success;
        this.message = message;
    }

    public List<TeamData> getTeam_members() {
        return team_members;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
