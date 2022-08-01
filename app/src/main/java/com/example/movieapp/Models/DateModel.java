package com.example.movieapp.Models;

public class DateModel {

    private String date,day,month;

    public DateModel(String date, String day, String month) {
        this.date = date;
        this.day = day;
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}

