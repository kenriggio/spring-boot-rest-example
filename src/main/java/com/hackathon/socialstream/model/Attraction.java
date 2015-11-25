package com.hackathon.socialstream.model;

/**
 * Created by ruchi on 11/25/15.
 */
public class Attraction {
    private String name;
    private String id;
    private String attractionSEOLink;
    private String attractionImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttractionSEOLink() {
        return attractionSEOLink;
    }

    public void setAttractionSEOLink(String attractionSEOLink) {
        this.attractionSEOLink = attractionSEOLink;
    }

    public String getAttractionImage() {
        return attractionImage;
    }

    public void setAttractionImage(String attractionImage) {
        this.attractionImage = attractionImage;
    }
}
