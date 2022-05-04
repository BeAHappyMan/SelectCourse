package com.SelectCourse.service;

import com.SelectCourse.pojo.User;

import java.util.List;

public interface UserDaoService {
    //用户登录
    public User userLogin(String userName);
    //用户注册
    public int userRegister(User user);
}
