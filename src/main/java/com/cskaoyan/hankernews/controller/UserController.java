package com.cskaoyan.hankernews.controller;

import com.cskaoyan.hankernews.bean.User;
import com.cskaoyan.hankernews.mapper.UserMapper;
import com.cskaoyan.hankernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping("reg/")
    @ResponseBody
    public String reg(String username,String password){

        return "";
    }
}
