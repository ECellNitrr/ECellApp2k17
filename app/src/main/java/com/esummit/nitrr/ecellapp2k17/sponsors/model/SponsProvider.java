package com.esummit.nitrr.ecellapp2k17.sponsors.model;

import com.esummit.nitrr.ecellapp2k17.sponsors.view.OnSponsReceived;

/**
 * Created by samveg on 23/6/17.
 */

public interface SponsProvider {
    void reqSpons(OnSponsReceived onSponsReceived);
}
