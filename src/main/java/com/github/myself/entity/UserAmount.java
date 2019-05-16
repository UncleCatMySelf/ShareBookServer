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
public class UserAmount implements Serializable {

    private static final long serialVersionUID = 7320028727043262239L;

    private Integer userId;

    private String deposit;

    private String recharge;

    private Date createTime;

    private Date updateTime;

}
