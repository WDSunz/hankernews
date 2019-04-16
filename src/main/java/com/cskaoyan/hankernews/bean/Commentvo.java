package com.cskaoyan.hankernews.bean;

public class Commentvo {
    User user;
    Comment comment;
    public Commentvo(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public Commentvo() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Commentvo{" +
                "user=" + user +
                ", comment=" + comment +
                '}';
    }
}
