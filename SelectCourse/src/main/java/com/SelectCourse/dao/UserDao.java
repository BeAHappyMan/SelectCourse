package com.SelectCourse.dao;
import com.SelectCourse.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    //用户登录
    List<User> userLogin(User user);

    //用户注册
    int userRegister(User user);
}
