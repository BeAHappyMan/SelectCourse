package com.SelectCourse;

import com.SelectCourse.pojo.User;
import com.SelectCourse.service.UserDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = SelectCourseApplication.class)
public class UserTest {
    @Autowired
    UserDaoService userDaoService;

    @Test
    public void queryUserTest(){
        User user = userDaoService.queryUserByUserNumber("123");
        System.out.println(user);
    }
    @Test
    public void addUserTest(){
        User user= new User();
        user.setUserType("学生");
        user.setUserPassword("123");
        user.setUserNumber("71120143");
        user.setUserName("王驰");
        int i = userDaoService.addUser(user);
        if(i>0)
            System.out.println("success");
    }
    @Test
    public void deleteUserTest(){
        int i = userDaoService.deleteUser("71120143");
        if(i>0)
            System.out.println("success");
    }

}
