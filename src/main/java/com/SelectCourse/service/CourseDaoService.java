package com.SelectCourse.service;

import com.SelectCourse.pojo.ClassTime;
import com.SelectCourse.pojo.Course;

import java.util.List;

public interface CourseDaoService {
    int deleteByCourseId(String courseId);

    int deleteClassTimeByCourseId(String courseId);

    List<String> getCourseId();

    List<Course> queryAllCourses(int startIndex,int pageSize);

    List<Course> queryAllCourses2(int startIndex,int pageSize);

    int addCourse(Course course);

    String getTeacherIdByCourseId(String courseId);

    int increaseCourseStudentNumber(String courseId);

    int decreaseCourseStudentNumber(String courseId);

    int getCourseMaxStudentNumber(String courseId);

    int getCourseStudentNumber(String courseId);

    Course queryCourseByCourseId(String courseId);

    int updateCoursePassInt(String courseId, int isPass);

    List<Course> queryByCourseLocation(String courseLocation);

    List<Course> queryAllByCourseTeacherIdCourses(String teacherId, int startIndex, int pageSize);

    int addClassTime(ClassTime classTime);
}
