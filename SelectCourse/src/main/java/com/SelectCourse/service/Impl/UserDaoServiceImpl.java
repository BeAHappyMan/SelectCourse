package com.SelectCourse.service.Impl;

import com.SelectCourse.dao.UserDao;
import com.SelectCourse.pojo.User;
import com.SelectCourse.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userDaoService")
public class UserDaoServiceImpl implements UserDaoService {


    @Autowired
    private UserDao userDao;

    @Override
    public List<User> userLogin(User user) {
        return userDao.userLogin(user);
    }

    @Override
    public int userRegister(User user) {
        return userDao.userRegister(user);
    }
}
