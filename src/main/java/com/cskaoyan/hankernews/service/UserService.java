package com.cskaoyan.hankernews.service;

import com.cskaoyan.hankernews.bean.User;

public interface UserService {
    User isUserExit(String username);
    int registUser(String username, String password);

    User login(String username, String password);

    User findUserById(String id);

    User findUserByNewsId(String id);

    User findUserByname(String toName);
}
