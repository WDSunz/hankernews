package com.cskaoyan.hankernews.service;

import com.cskaoyan.hankernews.bean.Message;
import com.cskaoyan.hankernews.bean.MessageVo;
import com.cskaoyan.hankernews.bean.Msg;

import java.util.List;

public interface MessageService {

    public int addMessage(int id, String toName, String content);

    List<MessageVo> findUserMessageByUserId(int id);

    List<Msg> findMessageByconversationId(String conversationId);

}
