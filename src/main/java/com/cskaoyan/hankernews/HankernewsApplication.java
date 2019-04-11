package com.cskaoyan.hankernews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.hankernews.mapper")
public class HankernewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HankernewsApplication.class, args);
    }

}
