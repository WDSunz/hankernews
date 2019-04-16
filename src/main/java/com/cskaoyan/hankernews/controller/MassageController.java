package com.cskaoyan.hankernews.controller;

import com.cskaoyan.hankernews.bean.Message;
import com.cskaoyan.hankernews.bean.MessageVo;
import com.cskaoyan.hankernews.bean.Msg;
import com.cskaoyan.hankernews.bean.User;
import com.cskaoyan.hankernews.service.MessageService;
import com.cskaoyan.hankernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MassageController {
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @RequestMapping("/user/tosendmsg")
    public  String toSendMsg(HttpServletRequest request, Model model){
        String contextPath = request.getContextPath();
        model.addAttribute("contextPath",contextPath);
        return "sendmsg";
    }

    @RequestMapping("/user/msg/addMessage")
    public  String addMessage(HttpServletRequest request, Model model,String toName,String content){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int id = user.getId();
        int i =messageService.addMessage(id,toName,content);
       return "redirect:/msg/list";
    }

    @RequestMapping("/msg/list")
    public  String msgList(HttpServletRequest request, Model model){

        String contextPath = request.getContextPath();
        model.addAttribute("contextPath",contextPath);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<MessageVo> messageVoList= messageService.findUserMessageByUserId(user.getId());
        model.addAttribute("conversations" ,messageVoList);

        return "letter";
    }

    @RequestMapping("/msg/detail")
    public String letterDetail(HttpServletRequest request, Model model ,String conversationId){
        String contextPath = request.getContextPath();
        List<Msg> messageList= messageService.findMessageByconversationId(conversationId);
        model.addAttribute("contextPath",contextPath);
        model.addAttribute("messages",messageList);
        return "letterDetail";
    }





}
