package com.paulevers.spotsgateway.mq.events;


import java.io.Serializable;

public class RequestAllSpotsEvent implements Serializable {
    private String spotName;

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }
}
