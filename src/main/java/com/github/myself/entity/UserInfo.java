package com.github.myself.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MySelf on 2019/5/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 8743496065534317824L;

    private Integer userId;

    private String avatarUrl;

    private String city;

    private String country;

    private Integer gender;

    private String nickname;

    private String province;

    private Date createTime;

    private Date updateTime;

    public UserInfo(Integer userId, String avatarUrl, String city, String country, Integer gender, String nickname, String province) {
        this.userId = userId;
        this.avatarUrl = avatarUrl;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.nickname = nickname;
        this.province = province;
    }

}
