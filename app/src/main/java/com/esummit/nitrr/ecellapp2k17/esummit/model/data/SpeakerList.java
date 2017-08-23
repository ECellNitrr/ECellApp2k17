package com.esummit.nitrr.ecellapp2k17.esummit.model.data;

import java.util.List;

/**
 * Created by iket on 14/8/17.
 */

public class SpeakerList {

    private List<SpeakerData> speakers;
    private boolean success;
    private String message;

    public SpeakerList(List<SpeakerData> speakers, boolean success, String message) {
        this.speakers = speakers;
        this.success = success;
        this.message = message;
    }

    public List<SpeakerData> getSpeakers() {
        return speakers;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
