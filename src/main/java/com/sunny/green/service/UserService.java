package com.sunny.green.service;

import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserVo getUserInfo(String user_id) {
        return userDao.selectAll1(user_id);
    }

    public void updateUser(UserVo user) {
        userDao.updateUser(user);
    }
    public void deleteUser(String userId) {
        userDao.deleteId(userId);
    }

}