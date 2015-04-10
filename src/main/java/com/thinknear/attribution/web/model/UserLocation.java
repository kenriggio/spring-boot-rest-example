package com.thinknear.attribution.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLocation extends ResourceSupport {

    @JsonProperty("id")
    private String userLocationId; // using userLocationId instead of Id, since ResourceSupport using id for link.
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lon")
    private String lon;


    public String getUserLocationId() {
        return userLocationId;
    }

    public void setUserLocationId(String userLocationId) {
        this.userLocationId = userLocationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}