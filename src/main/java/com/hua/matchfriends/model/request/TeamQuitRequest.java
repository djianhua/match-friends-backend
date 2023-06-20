package com.hua.matchfriends.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求体
 *
 * @author <a href="https://github.com/JianHuaDeng">hua</a>
 * @from <a href="https://blog.csdn.net/qq_59957669">hua的博客</a>
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * id
     */
    private Long teamId;

}
