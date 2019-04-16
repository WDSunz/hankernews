package com.cskaoyan.hankernews.service.impl;

import com.cskaoyan.hankernews.bean.User;
import com.cskaoyan.hankernews.mapper.UserMapper;
import com.cskaoyan.hankernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User isUserExit(String username) {
        User userExit = userMapper.isUserExit(username);
        return userExit;
    }

    @Override
    public int registUser(String username, String password) {
        int i = userMapper.registUser(username, password);
        return i;

    }

    @Override
    public User login(String username, String password) {
     User user=userMapper.findUserByUsernameAndPassword(username,password);
     return user;
    }

    @Override
    public User findUserById(String id) {
       User user= userMapper.findUserById(id);
       return user;
    }

    @Override
    public User findUserByNewsId(String id) {
        User user = userMapper.findUserByNewsId(id);
        return user;
    }

    @Override
    public User findUserByname(String toName) {
        User user=userMapper.findUserByname(toName);
        return user;
    }


}
