package com.hua.matchfriends.service;

import com.hua.matchfriends.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.matchfriends.model.domain.User;

/**
* @author 33116
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-06-13 10:15:24
*/
public interface TeamService extends IService<Team> {

    long addTeam(Team team, User loginUser);

}
