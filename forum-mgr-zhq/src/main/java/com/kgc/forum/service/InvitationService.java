package com.kgc.forum.service;

import com.kgc.forum.beans.Invitation;

import java.util.List;

public interface InvitationService {

    int getInvitationTotalCount(String TitleInfo);

    List<Invitation> getInvitationsByTitleAndPage(String TitleInfo, Integer pageSize, Integer pageNo);

    Boolean deleteInvitation(Integer id);
}
