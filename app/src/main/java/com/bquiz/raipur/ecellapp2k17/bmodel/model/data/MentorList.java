package com.bquiz.raipur.ecellapp2k17.bmodel.model.data;

import java.util.List;

/**
 * Created by samveg on 29/8/17.
 */

public class MentorList {
    private List<MentorData> mentors;
    private boolean success;
    private String message;

    public MentorList(List<MentorData> mentors, boolean success, String message) {
        this.mentors = mentors;
        this.success = success;
        this.message = message;
    }

    public List<MentorData> getMentors() {
        return mentors;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
