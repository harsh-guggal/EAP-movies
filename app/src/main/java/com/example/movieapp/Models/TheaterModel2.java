package com.example.movieapp.Models;

public class TheaterModel2 {

    private String theaterName,theaterLocation;

    public TheaterModel2(String theaterName, String theaterLocation) {
        this.theaterName = theaterName;
        this.theaterLocation = theaterLocation;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterLocation() {
        return theaterLocation;
    }

    public void setTheaterLocation(String theaterLocation) {
        this.theaterLocation = theaterLocation;
    }
}