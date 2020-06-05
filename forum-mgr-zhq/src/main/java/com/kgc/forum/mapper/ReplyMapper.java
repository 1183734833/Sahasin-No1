package com.kgc.forum.mapper;

import com.kgc.forum.beans.Reply;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReplyMapper {
    List<Reply> queryReplyList(@RequestParam("id") Integer id);

    int add(Reply reply);

    int delete(Integer id);
}
