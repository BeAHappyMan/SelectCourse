package com.SelectCourse;

import com.SelectCourse.pojo.User;
import com.SelectCourse.service.Impl.UserDaoServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.SelectCourse"})
@MapperScan("com.SelectCourse.dao")
public class SelectCourseApplication {

    public static void main(String[] args) {

        UserDaoServiceImpl userDaoService = new UserDaoServiceImpl();

        System.out.println(userDaoService.getUserDao());
        System.out.println(userDaoService);
        User user = userDaoService.userLogin("123");
        System.out.println(user);

        SpringApplication.run(SelectCourseApplication.class, args);
    }

}
