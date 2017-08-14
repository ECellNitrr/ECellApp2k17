package com.example.iket.ecellapp2k17.esummit.model.data;

/**
 * Created by iket on 14/8/17.
 */

public class SpeakerData {

    String speaker_name;
    String speaker_desc;
    String speaker_image_url;

    public SpeakerData(String speaker_name,String speaker_desc,String speaker_image_url){
        this.speaker_name=speaker_name;
        this.speaker_desc=speaker_desc;
        this.speaker_image_url=speaker_image_url;
    }

    public String getSpeaker_name(){return speaker_name;}
    public String getSpeaker_desc(){return speaker_desc;}
    public String getSpeaker_image_url(){return  speaker_image_url;};
}
