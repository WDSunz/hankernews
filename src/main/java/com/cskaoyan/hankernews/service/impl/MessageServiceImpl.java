package com.cskaoyan.hankernews.service.impl;

import com.cskaoyan.hankernews.bean.Message;
import com.cskaoyan.hankernews.bean.MessageVo;
import com.cskaoyan.hankernews.bean.Msg;
import com.cskaoyan.hankernews.bean.User;
import com.cskaoyan.hankernews.mapper.MessageMapper;
import com.cskaoyan.hankernews.mapper.UserMapper;
import com.cskaoyan.hankernews.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;




    @Override
    public int addMessage(int id, String toName, String content) {
        Date date = new Date();
        User toUser= userMapper.findUserByname(toName);
        if(toUser!=null) {
            int toId = toUser.getId();
            if (id <= toId) {
                int i = messageMapper.addMessage(id, toId, content, date);
            }else if(toId<id){
                int i = messageMapper.addMessage(toId, id, content, date);
            }
        }
        return 0;

    }

    @Override
    public List<MessageVo> findUserMessageByUserId(int id) {
        List<MessageVo> userMessageByUserId = messageMapper.findUserMessageByUserId(id);
        return userMessageByUserId;
    }

    @Override
    public List<Msg> findMessageByconversationId(String conversationId) {
        String[] split = conversationId.split("\\_");
        String conversationId2=split[1]+"_"+split[0];
        List<Msg> messageList= messageMapper.findUserMessageByconversationId(conversationId,conversationId2);
        for (Msg msg : messageList) {
            msg.setUserId(msg.getUser().getId());
            msg.setHeadUrl(msg.getUser().getHeadUrl());
        }
        return messageList;
    }
}
