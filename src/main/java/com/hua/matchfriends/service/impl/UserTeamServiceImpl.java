package com.hua.matchfriends.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.matchfriends.model.domain.UserTeam;
import com.hua.matchfriends.service.UserTeamService;
import com.hua.matchfriends.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author 33116
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-06-13 21:38:39
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




