package com.kgc.forum.service;

import com.kgc.forum.beans.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyList(Integer id);

    Boolean addReply(Reply reply);

    void deleteReply(Integer id);
}
