package com.SelectCourse.service.Impl;

import com.SelectCourse.dao.UserDao;
import com.SelectCourse.pojo.User;
import com.SelectCourse.service.UserDaoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service(value = "userDaoService")
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public User userLogin(String userNumber) {
        return userDao.userLogin(userNumber);
    }

    @Override
    public int userRegister(User user) {
        return userDao.userRegister(user);
    }
}
