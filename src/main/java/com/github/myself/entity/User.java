package com.github.myself.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MySelf on 2019/5/14.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

    private static final long serialVersionUID = -9193300274769203523L;

    private Integer userId;

    private String openid;

    private String sessionid;

    private Date createTime;

    private Date updateTime;

}
