package com.example.yonni.tp_0109;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yonni on 01/09/2016.
 */
public class PointOfInterest implements Serializable{

    protected String label;
    protected String description;
    protected double latitude;
    protected double longitude;
    protected Date visitedDate;
    protected double score;

    public PointOfInterest(String label, String description, double latitude, double longitude, Date visitedDate, double score){
        this.label          = label;
        this.description    = description;
        this.latitude       = latitude;
        this.longitude      = longitude;
        this.visitedDate    = visitedDate;
        this.score          = score;
    }

    @Override
    public String toString() {
        return this.getLabel();
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Date getVisitedDate() {
        return visitedDate;
    }

    public double getScore() {
        return score;
    }
}
