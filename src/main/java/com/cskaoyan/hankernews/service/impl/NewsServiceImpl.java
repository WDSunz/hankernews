package com.cskaoyan.hankernews.service.impl;

import com.cskaoyan.hankernews.bean.Vos;
import com.cskaoyan.hankernews.mapper.NewsMapper;
import com.cskaoyan.hankernews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;
    @Override
    public List<Vos> quaryAllNews() {
        List<Vos> vos = newsMapper.quaryAllNews();
        return vos;
    }
}
