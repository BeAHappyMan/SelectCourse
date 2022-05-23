package com.SelectCourse;

import com.SelectCourse.pojo.User;
import com.SelectCourse.service.UserDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

import static javax.xml.bind.DatatypeConverter.parseTime;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SelectCourseApplication.class)
public class UserTest {
//    @Autowired
//    UserDaoService userDaoService;

    @Test
    public void queryUserTest(){
        String d = "08:00";
        Calendar Time = parseTime(d);
        System.out.println(Time);
    }
//    @Test
//    public void addUserTest(){
//        User user= new User();
//        user.setUserType("学生");
//        user.setUserPassword("123");
//        user.setUserId("71120143");
//        user.setUserName("王驰");
//        int i = userDaoService.addUser(user);
//        if(i>0)
//            System.out.println("success");
//    }
//    @Test
//    public void deleteUserTest(){
//        int i = userDaoService.deleteUser("71120143");
//        if(i>0)
//            System.out.println("success");
//    }

}
