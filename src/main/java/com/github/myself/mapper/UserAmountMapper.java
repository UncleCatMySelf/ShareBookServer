package com.github.myself.mapper;

import com.github.myself.entity.UserAmount;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by MySelf on 2019/5/16.
 */
@Mapper
public interface UserAmountMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserAmount record);

    int insertSelective(UserAmount record);

    UserAmount selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserAmount record);

    int updateByPrimaryKey(UserAmount record);
}
