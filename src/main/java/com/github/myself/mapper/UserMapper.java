package com.github.myself.mapper;

import com.github.myself.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by MySelf on 2019/5/14.
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户小程序的用户登录验证，根据openid返回用户信息及id
     * @param wxOpenid
     * @return
     */
    User selectByOpenId(String wxOpenid);
}
