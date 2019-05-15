package com.github.myself.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MySelf on 2019/5/14.
 */
@Data
public class User implements Serializable{

    private static final long serialVersionUID = -9193300274769203523L;

    private Integer userId;

    private String openid;

    private String sessionid;

    private Date createTime;

    private Date updateTime;

    public User() {
    }

    public User(Integer userId, String openid, String sessionid, Date createTime, Date updateTime) {
        this.userId = userId;
        this.openid = openid;
        this.sessionid = sessionid;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
