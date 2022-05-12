package com.SelectCourse.service.Impl;

import com.SelectCourse.dao.CourseDao;
import com.SelectCourse.pojo.Course;
import com.SelectCourse.service.CourseDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDaoServiceImpl implements CourseDaoService {

    @Autowired
    CourseDao courseDao;
    @Override
    public List<Course> queryAllCourses(int startIndex,int pageSize){
        return courseDao.queryAllCourses(startIndex, pageSize);
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public String getTeacherIdByCourseId(String courseId) {
        return courseDao.getTeacherIdByCourseId(courseId);
    }

    @Override
    public int increaseCourseStudentNumber(String courseId) {
        return courseDao.increaseCourseStudentNumber(courseId);
    }

    @Override
    public int decreaseCourseStudentNumber(String courseId) {
        return courseDao.decreaseCourseStudentNumber(courseId);
    }


    @Override
    public int getCourseMaxStudentNumber(String courseId) {
        return courseDao.getCourseMaxStudentNumber(courseId);
    }

    @Override
    public int getCourseStudentNumber(String courseId) {
        return courseDao.getCourseStudentNumber(courseId);
    }

    @Override
    public Course queryCourseByCourseId(String courseId) {
        return courseDao.queryCourseByCourseId(courseId);
    }
}
