package com.example.iket.ecellapp2k17.esummit.model.data;

import java.util.List;

/**
 * Created by iket on 14/8/17.
 */

public class SpeakerList {

    private List<SpeakerData> speakers;

    public SpeakerList(List<SpeakerData> speakers) {
        this.speakers = speakers;
    }

    public List<SpeakerData> getSpeakers(){
        return speakers;
    }
}
