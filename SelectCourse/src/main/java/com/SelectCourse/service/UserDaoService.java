package com.SelectCourse.service;

import com.SelectCourse.pojo.User;

import java.util.List;

public interface UserDaoService {
    //用户登录
    User userLogin(String userName);
    //用户注册
    int userRegister(User user);
}
