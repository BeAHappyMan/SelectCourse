package com.SelectCourse.dao;
import com.SelectCourse.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao {
    //用户登录
    User queryUserByUserNumber(String userNumber);

    //用户注册
    int addUser(User user);

    int deleteUser(String userNumber);
}
