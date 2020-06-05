package com.kgc.forum.mapper;

import java.util.List;
import com.kgc.forum.beans.Invitation;
import org.apache.ibatis.annotations.Param;

public interface InvitationMapper {

    int queryInvitationTotalCount(@Param("searchInfo") String TitleInfo);

    List<Invitation> queryInvitationByTitleAndPage(@Param("searchInfo") String TitleInfo,@Param("pageSize")Integer pageSize,@Param("pageIndex")Integer pageIndex);

    int delete(Integer id);
}
