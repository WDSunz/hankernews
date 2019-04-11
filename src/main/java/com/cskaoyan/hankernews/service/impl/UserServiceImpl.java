package com.cskaoyan.hankernews.service.impl;

import com.cskaoyan.hankernews.mapper.UserMapper;
import com.cskaoyan.hankernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
}
