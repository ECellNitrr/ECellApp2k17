package com.bquiz.raipur.ecellapp2k17.sponsors.model.data;

import java.util.List;

/**
 * Created by iket on 19/8/17.
 */

public class SponsParent {
    boolean success;
    String message;
    List<SponsHeading> spons;

    public SponsParent(boolean success, String message, List<SponsHeading> spons) {
        this.success = success;
        this.message = message;
        this.spons = spons;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<SponsHeading> getSpons() {
        return spons;
    }
}
