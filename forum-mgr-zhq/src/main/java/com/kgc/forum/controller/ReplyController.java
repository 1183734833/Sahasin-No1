package com.kgc.forum.controller;

import com.kgc.forum.beans.Reply;
import com.kgc.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ReplyController {

    @Autowired(required = false)
    private ReplyService replyService;

    @RequestMapping(value = "/toAddReply",method = RequestMethod.GET)
    public String toAddReply(Map<String,Object> map , HttpServletRequest request) {
        String invid = request.getParameter("invid");
        map.put("invid",invid);
        return "ReplyAdd";
    }

    @ResponseBody
    @RequestMapping(value = "AddReply",method = RequestMethod.POST)
    public Boolean AddReply(Reply reply){
        return replyService.addReply(reply);
    }


}
