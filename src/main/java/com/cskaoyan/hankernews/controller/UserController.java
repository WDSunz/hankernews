package com.cskaoyan.hankernews.controller;

import com.cskaoyan.hankernews.bean.User;
import com.cskaoyan.hankernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/reg")
    @ResponseBody
    public Map reg(String username, String password, HttpSession session) {
        User userExit = userService.isUserExit(username);
        System.out.println(username + password);
        HashMap map = new HashMap();
        if (userExit != null) {
            map.put("code", 1);
            map.put("msgname", "用户名已经被注册");
        } else {
            int i = userService.registUser(username, password);
            if (i == 1) {
                userExit = userService.isUserExit(username);
                session.setAttribute("user", userExit);
                map.put("code", 0);
                map.put("msgname", "注册成功");
            }
        }
        return map;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        HashMap map = new HashMap();
        if (user == null) {
            map.put("code", 1);
            map.put("msgpwd", "密码不正确");
        } else {
            session.setAttribute("user", user);
            map.put("code", 0);
            map.put("msgname", "登陆成功");
        }
        return map;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpSession session,Model model){
        session.removeAttribute("user");
        return "redirect:/home";

    }

    @RequestMapping("/user/{id}")
    public String person(@PathVariable String id, Model model, HttpServletRequest request){
        User user = userService.findUserById(id);
        String contextPath = request.getContextPath();
        model.addAttribute("contextPath",contextPath);
     /*   model.addAttribute("user",user);

        System.out.println(user);
        System.out.println(user);
        System.out.println(user);*/
        return "personal" ;
    }








}
