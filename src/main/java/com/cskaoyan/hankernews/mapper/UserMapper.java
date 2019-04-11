package com.cskaoyan.hankernews.mapper;

import com.cskaoyan.hankernews.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    public User queryUserByUid(@Param("uid") String uid);

    int registUser(String username, @Param("password") String password);

    User isUserExit(@Param("username") String username);

    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}