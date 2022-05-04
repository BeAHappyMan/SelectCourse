package com.SelectCourse.service;

import com.SelectCourse.pojo.User;

import java.util.List;

public interface UserDaoService {
    //用户登录
    User queryUserByUserNumber(String userName);
    //用户注册
    int addUser(User user);

    int deleteUser(String userNumber);
}
