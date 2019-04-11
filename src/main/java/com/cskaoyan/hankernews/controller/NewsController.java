package com.cskaoyan.hankernews.controller;

import com.cskaoyan.hankernews.bean.Vos;
import com.cskaoyan.hankernews.service.NewsService;
import com.cskaoyan.hankernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("MyNews")
public class NewsController {


    @Autowired
    NewsService newsService;


    @RequestMapping("/")
    public String hello(Model model , HttpServletRequest request){
        List<Vos> vos = newsService.quaryAllNews();
        String contextPath = request.getContextPath();
        model.addAttribute("contextPath",contextPath);

        model.addAttribute("vos",vos);
        return "home";
    }

}
