package com.backbase.atm.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "lat", "lng" })
public class GeoLocation {

    private String lat;
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(final String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(final String lng) {
        this.lng = lng;
    }
}