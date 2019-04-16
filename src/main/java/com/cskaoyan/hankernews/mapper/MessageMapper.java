package com.cskaoyan.hankernews.mapper;

import com.cskaoyan.hankernews.bean.Message;
import com.cskaoyan.hankernews.bean.MessageVo;
import com.cskaoyan.hankernews.bean.Msg;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MessageMapper {
    int addMessage(@Param("id") int id, @Param("toId")int toId,@Param("content") String content, @Param("date")Date date);
    List<Message> findAllMessage();
    List<MessageVo> findUserMessageByUserId(@Param("id")int id);

    List<Msg> findUserMessageByconversationId(@Param("conversationId")String conversationId, @Param("conversationId2") String conversationId2);
}
