package com.cskaoyan.hankernews.bean;

import com.cskaoyan.hankernews.bean.User;

public class Vos {
    int like;
    User user;
    News news;


    public Vos() {
    }

    public Vos(int like, User user, News news) {
        this.like = like;
        this.user = user;
        this.news = news;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Vos{" +
                "like=" + like +
                ", user=" + user +
                ", news=" + news +
                '}';
    }
}
