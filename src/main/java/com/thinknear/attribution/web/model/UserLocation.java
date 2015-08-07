package com.thinknear.attribution.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLocation {

    @JsonProperty("id")
    private String userLocationId; // using userLocationId instead of Id, since ResourceSupport using id for link.
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lon")
    private String lon;

    @ApiModelProperty(required = false, value = "Unique Identifier of this Object")
    public String getUserLocationId() {
        return userLocationId;
    }

    public void setUserLocationId(String userLocationId) {
        this.userLocationId = userLocationId;
    }
    
    @ApiModelProperty(required = false, value = "UserId for Location")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ApiModelProperty(required = false, value = "Latitude")
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @ApiModelProperty(required = false, value = "Longtitude")
    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}