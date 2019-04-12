package com.cskaoyan.hankernews.service;

import com.cskaoyan.hankernews.bean.News;
import com.cskaoyan.hankernews.bean.Vos;

import java.util.Date;
import java.util.List;

public interface NewsService {
    public List<News> quaryAllNews();

    int createNews(String image, String title, String link, Date date,int id);

    List<Vos> quaryAllNewsAndUser();
}

