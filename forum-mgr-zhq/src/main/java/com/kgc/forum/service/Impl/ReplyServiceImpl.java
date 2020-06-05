package com.kgc.forum.service.Impl;
import com.kgc.forum.beans.Reply;
import com.kgc.forum.mapper.ReplyMapper;
import com.kgc.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired(required = false)
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> getReplyList(Integer id) {
        return replyMapper.queryReplyList(id);
    }

    @Override
    public Boolean addReply(Reply reply) {
        int row = replyMapper.add(reply);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public void deleteReply(Integer id) {
        replyMapper.delete(id);
    }
}
