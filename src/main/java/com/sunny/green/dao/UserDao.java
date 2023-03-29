package com.sunny.green.dao;

import com.sunny.green.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public int joinUser(UserVo user);

    public UserVo selectUser(UserVo user);
}
