package com.cskaoyan.hankernews.service;

import com.cskaoyan.hankernews.bean.Commentvo;

import java.util.List;

public interface CommentService {
    List<Commentvo> findCommentAndUserByNewsId(String id);

}
