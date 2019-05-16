package com.github.myself.mapper;

import com.github.myself.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by MySelf on 2019/5/16.
 */
@Mapper
public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int selectByUserId(Integer userId);

    /**
     * 返回全部用户基本信息列表
     * @return
     */
    List<UserInfo> selectAllUsers();

}
