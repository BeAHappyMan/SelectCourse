package com.SelectCourse.dao;

import com.SelectCourse.pojo.ClassTime;
import com.SelectCourse.pojo.Course;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseDao {
    List<String> getCourseId();

    List<Course> queryAllCourses(int startIndex,int pageSize);

    List<Course> queryAllCourses2(int startIndex,int pageSize);

    List<Course> queryByCourseLocation(String courseLocation);

    Course queryCourseByCourseId(String courseId);

    int addCourse(Course course);

    int addClassTime(ClassTime classTime);

    String getTeacherIdByCourseId(String courseId);

    int increaseCourseStudentNumber(String courseId);

    int decreaseCourseStudentNumber(String courseId);

    int getCourseMaxStudentNumber(String courseId);

    int getCourseStudentNumber(String courseId);

    int updateCoursePassInt(String courseId, int isPass);

    List<Course> queryAllByCourseTeacherIdCourses(String teacherId, int startIndex, int pageSize);
}
