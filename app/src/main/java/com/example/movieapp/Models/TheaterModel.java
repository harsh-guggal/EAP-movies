package com.example.movieapp.Models;

public class TheaterModel {
    // string course_name for storing movie_name
    // and imgid for storing image id.
    private String theater_name,theater_email,theater_number,theater_location;
    private int imgid;

    public TheaterModel(String theater_name, String theater_email, String theater_number, String theater_location, int imgid) {
        this.theater_name = theater_name;
        this.theater_email = theater_email;
        this.theater_number = theater_number;
        this.theater_location = theater_location;
        this.imgid = imgid;
    }

    public void setTheater_email(String theater_email) {
        this.theater_email = theater_email;
    }

    public void setTheater_number(String theater_number) {
        this.theater_number = theater_number;
    }

    public void setTheater_location(String theater_location) {
        this.theater_location = theater_location;
    }

    public String getTheater_email() {
        return theater_email;
    }

    public String getTheater_number() {
        return theater_number;
    }

    public String getTheater_location() {
        return theater_location;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
