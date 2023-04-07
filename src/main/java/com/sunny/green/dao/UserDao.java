package com.sunny.green.dao;

import com.sunny.green.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public int joinUser(UserVo user);

    public UserVo selectUser(UserVo user);
    public UserVo selectUserId(String userId);

    //보영
    public List<UserVo> selectAll();
}
