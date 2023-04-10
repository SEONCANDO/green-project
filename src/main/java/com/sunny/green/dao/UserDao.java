package com.sunny.green.dao;

import com.sunny.green.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Mapper
public interface UserDao {

    public int joinUser(UserVo user);

    public UserVo selectUser(UserVo user);
    public UserVo selectUserId(String userId);

    //보영(회원조회)
    public List<UserVo> selectAll();

    //보영(회원정보수정)
    public void updateUser(UserVo user);

}
