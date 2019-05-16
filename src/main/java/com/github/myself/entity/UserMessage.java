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
public class UserMessage implements Serializable {

    private static final long serialVersionUID = -6026165595734344445L;

    private Integer userId;

    private String userBookNum;

    private String userAllTime;

    private String userIntegral;

    private Date createTime;

    private Date updateTime;
}
