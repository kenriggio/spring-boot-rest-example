package com.thinknear.attribution.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(value = "Location of a User")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLocation extends ResourceSupport {

    @ApiModelProperty(value = "The surrogate key for this record", required=false)
    @JsonProperty("id")
    private String userLocationId; // using userLocationId instead of Id, since ResourceSupport using id for link.
    @ApiModelProperty(value = "The user id for this event", required=false)
    @JsonProperty("userId")
    private String userId;
    @ApiModelProperty(value = "latitude of the user for this event", required=false)
    @JsonProperty("lat")
    private String lat;
    @ApiModelProperty(value = "longitude of the user for this event", required=false)
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