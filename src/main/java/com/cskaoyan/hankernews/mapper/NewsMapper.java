package com.cskaoyan.hankernews.mapper;

import com.cskaoyan.hankernews.bean.News;
import com.cskaoyan.hankernews.bean.Vos;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface NewsMapper {
    public List<News> quaryAllNews();

    List<Vos> quaryAllNewsAndUser();

    int addNews(@Param("image") String image, @Param("title")String title, @Param("link")String link, @Param("date") Date date, @Param("id")int id);
}
