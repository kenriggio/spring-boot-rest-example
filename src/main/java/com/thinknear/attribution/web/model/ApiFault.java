package com.thinknear.attribution.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiFault {

    /**
     * The HTTP status code (see Section 6 [RFC7231]. REQUIRED
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6">Section 6 [RFC7231]</a>
     */
    @JsonProperty("status")
    private String status;

    /**
     * A detailed error keyword. OPTIONAL
     */
    @JsonProperty("type")
    private String type;

    /**
     * A detailed, human readable message. OPTIONAL
     */
    @JsonProperty("detail")
    private String detail; //optional

    public ApiFault(String status, String type, String detail) {
        this.status = status;
        this.type = type;
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

}
