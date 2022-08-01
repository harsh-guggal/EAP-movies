package com.example.movieapp.Models;

public class MovieModel {
    // string course_name for storing movie_name
    // and imgid for storing image id.
    private String movie_name;
    private int imgid;

    public MovieModel(String course_name, int imgid) {
        this.movie_name = course_name;
        this.imgid = imgid;
    }


    public String getCourse_name() {
        return movie_name;
    }

    public void setCourse_name(String course_name) {
        this.movie_name = course_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
