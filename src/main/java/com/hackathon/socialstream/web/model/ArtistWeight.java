package com.hackathon.socialstream.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistWeight {

    @JsonProperty("id")
    private String artistWeightId; // using userLocationId instead of Id, since ResourceSupport using id for link.
    @JsonProperty("attractionId")
    private String attractionId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("weight")
    private String weight;

    @ApiModelProperty(required = false, value = "Unique Identifier of this Object")
    public String getArtistWeightId() {
        return artistWeightId;
    }

    public void setArtistWeightId(String artistWeightId) {
        this.artistWeightId = artistWeightId;
    }
    
    @ApiModelProperty(required = false, value = "AttractionId")
    public String getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(String attractionId) {
        this.attractionId = attractionId;
    }

    @ApiModelProperty(required = false, value = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(required = false, value = "Weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}