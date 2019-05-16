package com.github.myself.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by MySelf on 2019/5/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMessageVo implements Serializable {

    private static final long serialVersionUID = -110898377868901829L;

    private String userId;

    private String bookNum;

    private String allTime;

    private String title;

}
