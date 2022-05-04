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
    public void LoginTest(){
        User user = userDaoService.userLogin("123");
        System.out.println(userDaoService);
        System.out.println(user);
    }

}
