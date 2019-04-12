package com.cskaoyan.hankernews.controller;

import com.cskaoyan.hankernews.bean.User;
import com.cskaoyan.hankernews.bean.Vos;
import com.cskaoyan.hankernews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@Controller
public class NewsController {


    @Autowired
    NewsService newsService;


    @RequestMapping("/")
    public String hello(Model model, HttpServletRequest request) {
        List<Vos> vos = newsService.quaryAllNewsAndUser();
        String contextPath = request.getContextPath();
        model.addAttribute("contextPath", contextPath);
        model.addAttribute("vos", vos);
        return "home";
    }

    @RequestMapping("uploadImage")
    @ResponseBody
    public Map upLoadImage(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        HashMap map = new HashMap();
        uuid = uuid + "." + suffix;

        URL resource = NewsController.class.getClassLoader().getResource("static/images/");
        String path = resource.getPath();
        File saveFile = new File(path + uuid);

        try {
            file.transferTo(saveFile);
            map.put("code", 0);
            map.put("msg", "http://localhost/images/" + uuid);

        } catch (IOException e) {
            e.printStackTrace();
            map.put("code", 1);
            map.put("msg", "文件上传失败");
        }

        return map;
    }

    @RequestMapping("/user/addNews")
    @ResponseBody
    public HashMap addNews(String image, String title, String link, HttpSession session) {
        Date date = new Date();
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        System.out.println(id);
        HashMap map = new HashMap();
        int i = newsService.createNews(image, title, link, date, id);
        if(i==1){
            map.put("code", 0);
            map.put("msg", "成功");
        }else {
            map.put("code", 1);
            map.put("msg", "失败");
        }
        return map;
    }



}
