package com.hua.matchfriends.service;

import com.hua.matchfriends.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.matchfriends.model.domain.User;
import com.hua.matchfriends.model.dto.TeamQuery;
import com.hua.matchfriends.model.request.TeamJoinRequest;
import com.hua.matchfriends.model.request.TeamQuitRequest;
import com.hua.matchfriends.model.request.TeamUpdateRequest;
import com.hua.matchfriends.model.vo.TeamUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 33116
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-06-13 10:15:24
*/
public interface TeamService extends IService<Team> {

    long addTeam(Team team, User loginUser);

    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin, HttpServletRequest request);

    /**
     * 修改队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    boolean deleteTeam(long id, User loginUser);
}
