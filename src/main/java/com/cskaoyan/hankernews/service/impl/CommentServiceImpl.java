package com.cskaoyan.hankernews.service.impl;

import com.cskaoyan.hankernews.bean.Commentvo;
import com.cskaoyan.hankernews.mapper.CommentMapper;
import com.cskaoyan.hankernews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Commentvo> findCommentAndUserByNewsId(String id) {
        List<Commentvo>   commentvoList=  commentMapper.findCommentAndUserByNewsId(id);
        return commentvoList;
    }
}
