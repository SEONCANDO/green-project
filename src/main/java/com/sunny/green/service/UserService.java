package com.sunny.green.service;

import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {


    public UserVo kakaoUser(String code);


}
