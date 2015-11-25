package com.hackathon.socialstream.model;

/**
 * Created by ruchi on 11/25/15.
 */
public class Event {
    private String eventName;

    public EventAttractionList getEventAttractionList() {
        return eventAttractionList;
    }

    public void setEventAttractionList(EventAttractionList eventAttractionList) {
        this.eventAttractionList = eventAttractionList;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    private EventAttractionList eventAttractionList;

}
