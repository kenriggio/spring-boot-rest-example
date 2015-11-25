package com.hackathon.socialstream.model;

import java.util.ArrayList;

/**
 * Created by ruchi on 11/25/15.
 */
public class EventList {
    public ArrayList<Event> getEvent() {
        return event;
    }

    public void setEvent(ArrayList<Event> event) {
        this.event = event;
    }

    private ArrayList<Event> event;
}

