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
        SpringApplication.run(SelectCourseApplication.class, args);
    }

}
