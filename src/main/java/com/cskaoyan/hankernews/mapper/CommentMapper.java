package com.cskaoyan.hankernews.mapper;

import com.cskaoyan.hankernews.bean.Commentvo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    List<Commentvo> findCommentAndUserByNewsId(@Param("id") String id);
}
