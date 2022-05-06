package com.SelectCourse.service;

import com.SelectCourse.pojo.Course;

import java.util.List;

public interface CourseDaoService {

    List<Course> queryAllCourses();

    int addCourse(Course course);
}
