package com.kgc.forum.service.Impl;
import com.kgc.forum.beans.Invitation;
import com.kgc.forum.mapper.InvitationMapper;
import com.kgc.forum.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvitationServiceImpl  implements InvitationService {

    @Autowired(required = false)
    private InvitationMapper invitationMapper;

    @Override
    public int getInvitationTotalCount(String TitleInfo) {
        return invitationMapper.queryInvitationTotalCount(TitleInfo);
    }

    @Override
    public List<Invitation> getInvitationsByTitleAndPage(String TitleInfo, Integer pageSize, Integer pageNo){
        return invitationMapper.queryInvitationByTitleAndPage(TitleInfo, pageSize,(pageNo - 1) * pageSize);
    }

    @Override
    public Boolean deleteInvitation(Integer id) {
        int row = invitationMapper.delete(id);
        if(row>0){
            return true;
        }
        return false;
    }

}
