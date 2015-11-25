package com.hackathon.socialstream.model;

import java.util.ArrayList;

/**
 * Created by ruchi on 11/25/15.
 */
public class EventAttractionList {
    public ArrayList<Attraction> getAttraction() {
        return attraction;
    }

    public void setAttraction(ArrayList<Attraction> attraction) {
        this.attraction = attraction;
    }

    private ArrayList<Attraction> attraction;
}
