package com.hackathon.socialstream.model;

/**
 * Created by ruchi on 11/25/15.
 */
public class EventsResponse {

    public EventList getEventList() {
        return eventList;
    }

    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

    private EventList eventList;
}
