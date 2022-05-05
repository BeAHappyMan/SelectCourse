package com.SelectCourse.dao;

import com.SelectCourse.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseDao {
    List<Course> queryAllCourses();

    int addCourse(Course course);
}
