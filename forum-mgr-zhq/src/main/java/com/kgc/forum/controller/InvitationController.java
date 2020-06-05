package com.kgc.forum.controller;

import com.kgc.forum.beans.Invitation;
import com.kgc.forum.beans.PageSupport;
import com.kgc.forum.beans.Reply;
import com.kgc.forum.service.InvitationService;
import com.kgc.forum.service.ReplyService;
import org.apache.commons.lang3.StringUtils;
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
public class InvitationController {

    @Autowired(required = false)
    private InvitationService invitationService;

    @Autowired(required = false)
    private ReplyService replyService;


    @RequestMapping("/InvitationListPage")
    public String InvitationListPage(Map<String,Object> map,HttpServletRequest request){
        int pageSize = 4;
        int pageNo = StringUtils.isEmpty(request.getParameter("pageNo")) ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        String TitleInfo = request.getParameter("searchInfo");
        int totalCount = invitationService.getInvitationTotalCount(TitleInfo);
        System.out.println("theTotalCountis:"+totalCount);
        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPage = pageSupport.getTotalPage();
        if(pageNo < 1){
            pageNo = 1;
        } else if(pageNo > totalPage){
            pageNo = totalPage;
        }
        pageSupport.setCurrentPageNo(pageNo);
        map.put("page",pageSupport);

        List<Invitation> invitations =invitationService.getInvitationsByTitleAndPage(TitleInfo,pageSize,pageNo);
        map.put("invitations",invitations);

        return "InvitationList";
    }

    @RequestMapping(value = "/toReplyList",method = RequestMethod.GET)
    public String toReplyList(@RequestParam("id") Integer id,Map<String,Object> map){
            List<Reply> replies =replyService.getReplyList(id);
            map.put("replies",replies);
            map.put("invid",id);
        return "ReplyList";
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public Boolean delete(@RequestParam("id") Integer id) {
        replyService.deleteReply(id);
        return invitationService.deleteInvitation(id);
    }
}
