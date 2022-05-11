package com.SelectCourse.service;

import com.SelectCourse.pojo.Course;

import java.util.List;

public interface CourseDaoService {

    List<Course> queryAllCourses();

    int addCourse(Course course);

    String getTeacherIdByCourseId(String courseId);

    int increaseCourseStudentNumber(String courseId);

    int decreaseCourseStudentNumber(String courseId);

    int getCourseMaxStudentNumber(String courseId);

    int getCourseStudentNumber(String courseId);
}
