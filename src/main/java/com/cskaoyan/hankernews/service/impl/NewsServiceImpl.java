package com.cskaoyan.hankernews.service.impl;

import com.cskaoyan.hankernews.bean.News;
import com.cskaoyan.hankernews.bean.Vos;
import com.cskaoyan.hankernews.mapper.NewsMapper;
import com.cskaoyan.hankernews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;
    @Override
    public List<News> quaryAllNews() {
        List<News> news = newsMapper.quaryAllNews();
        return news;
    }

    @Override
    public int createNews(String image, String title, String link, Date date,int id) {
        int i = newsMapper.addNews(image, title, link, date, id);
        return i;
    }

    @Override
    public List<Vos> quaryAllNewsAndUser() {
        List<Vos> vos = newsMapper.quaryAllNewsAndUser();
        return vos;
    }
}
