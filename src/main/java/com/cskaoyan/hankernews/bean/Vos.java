package com.cskaoyan.hankernews.bean;

import com.cskaoyan.hankernews.bean.User;

public class Vos {
    User user;
    News news;

    public Vos() {
    }

    public Vos(User user, News news) {
        this.user = user;
        this.news = news;
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
                "user=" + user +
                ", news=" + news +
                '}';
    }
}
