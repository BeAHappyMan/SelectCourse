package com.SelectCourse;

import com.SelectCourse.pojo.Course;
import com.SelectCourse.service.CourseDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SelectCourseApplication.class)
public class CourseTest {

    @Autowired
    CourseDaoService courseDaoService;

    @Test
    public void queryAllCoursesTest(){
        List<Course> courses = courseDaoService.queryAllCourses();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void addCourseTest(){
        Course course = new Course();
        course.setCourseName("123");
        course.setCourseId("123");
        course.setCoursePass(0);
        course.setCourseMaxStudentNumber(50);
        course.setCourseTeacherId("t1");
        int i = courseDaoService.addCourse(course);
        if(i>0)
            System.out.println("success");

    }


}
