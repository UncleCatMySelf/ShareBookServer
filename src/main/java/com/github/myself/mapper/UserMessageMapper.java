package com.github.myself.mapper;

import com.github.myself.entity.UserMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by MySelf on 2019/5/16.
 */
@Mapper
public interface UserMessageMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);

    /**
     * 查询全部用户的小程序用户信息页面
     * @return
     */
    List<UserMessage> selectAllUsers();
}
