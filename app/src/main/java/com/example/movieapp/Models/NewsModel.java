package com.example.movieapp.Models;

public class NewsModel {

    private int imgId;
    private String news_title,news_desc;

    public NewsModel(int imgId, String news_title, String news_desc) {
        this.imgId = imgId;
        this.news_title = news_title;
        this.news_desc = news_desc;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_desc() {
        return news_desc;
    }

    public void setNews_desc(String news_desc) {
        this.news_desc = news_desc;
    }
}
