package com.cskaoyan.hankernews.service.impl;

import com.cskaoyan.hankernews.bean.News;
import com.cskaoyan.hankernews.bean.Vos;
import com.cskaoyan.hankernews.mapper.NewsMapper;
import com.cskaoyan.hankernews.service.NewsService;
import com.cskaoyan.hankernews.utils.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

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
    public int createNews(String image, String title, String link, Date date, int id) {
        int i = newsMapper.addNews(image, title, link, date, id);
        return i;
    }

    @Override
    public List<Vos> quaryAllNewsAndUser() {
        List<Vos> vos = newsMapper.quaryAllNewsAndUser();
        Jedis jedis = JedisUtils.getJedisFromPool();
        for (Vos vo : vos) {
            int newsId = vo.getNews().getId();
            String likeNews = "likeNews" + newsId;
            vo.setLike(0);
            Long scard = jedis.scard(likeNews);
            int i = scard.intValue();
            vo.getNews().setLikeCount(i);
        }
        jedis.close();
        return vos;
    }

    @Override
    public News findNewsById(String id) {
        News news = newsMapper.findNewsById(id);
        return news;
    }

    @Override
    public String likeNews(int id, String newsId) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        String sid = String.valueOf(id);
        String likeNews = "likeNews" + newsId;
        String disLike = "disLikeNews" + newsId;
        Boolean sismember = jedis.sismember(likeNews, sid);
        if (!sismember) {
            jedis.sadd(likeNews, sid);
        }
        Boolean sismember1 = jedis.sismember(disLike, sid);
        if (sismember1) {
            jedis.srem(disLike, sid);
        }

        Long scard = jedis.scard(likeNews);
        String s = String.valueOf(jedis.scard(likeNews));
        jedis.close();
        return s;
    }

    @Override
    public String disLikeNews(int id, String newsId) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        String sid = String.valueOf(id);
        String likeNews = "likeNews" + newsId;
        String disLike = "disLikeNews" + newsId;
        Boolean disLike1 = jedis.sismember(disLike, sid);
        if (!disLike1) {
            jedis.sadd(disLike, sid);
        }
        Boolean sismember = jedis.sismember(likeNews, sid);
        if (sismember) {
            jedis.srem(likeNews, sid);
        }
        String s = String.valueOf(jedis.scard(likeNews));
        jedis.close();
        return s;
    }

    @Override
    public List<Vos> quaryAllNewsAndUserByLogin(int id) {
        List<Vos> vos = newsMapper.quaryAllNewsAndUser();
        Jedis jedis = JedisUtils.getJedisFromPool();
        for (Vos vo : vos) {
            int newsId = vo.getNews().getId();
            String sid = String.valueOf(id);
            String likeNews = "likeNews" + newsId;
            String disLike = "disLikeNews" + newsId;
            Boolean isLikeNews = jedis.sismember(likeNews, sid);
            Boolean isDisLike = jedis.sismember(disLike, sid);
            if (isLikeNews) {
                vo.setLike(1);
            } else if (isDisLike) {
                vo.setLike(-1);
            } else if (!isDisLike && !isLikeNews) {
                vo.setLike(0);
            }
            Long scard = jedis.scard(likeNews);
            int i = scard.intValue();
            vo.getNews().setLikeCount(i);
        }
        jedis.close();
        return vos;
    }


}
