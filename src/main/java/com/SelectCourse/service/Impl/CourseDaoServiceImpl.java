package com.SelectCourse.service.Impl;

import com.SelectCourse.dao.CourseDao;
import com.SelectCourse.pojo.ClassTime;
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
    public int deleteByCourseId(String courseId) {
        return courseDao.deleteByCourseId(courseId);
    }

    @Override
    public int deleteClassTimeByCourseId(String courseId) {
        return courseDao.deleteClassTimeByCourseId(courseId);
    }

    @Override
    public List<String> getCourseId() {
        return courseDao.getCourseId();
    }

    @Override
    public List<Course> queryAllCourses(int startIndex,int pageSize){
        return courseDao.queryAllCourses(startIndex, pageSize);
    }

    @Override
    public List<Course> queryAllCourses2(int startIndex, int pageSize) {
        return courseDao.queryAllCourses2(startIndex, pageSize);
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

    @Override
    public int updateCoursePassInt(String courseId, int isPass) {
        return courseDao.updateCoursePassInt(courseId,isPass);
    }

    @Override
    public List<Course> queryByCourseLocation(String courseLocation) {
        return courseDao.queryByCourseLocation(courseLocation);
    }

    @Override
    public List<Course> queryAllByCourseTeacherIdCourses(String teacherId, int startIndex, int pageSize) {
        return courseDao.queryAllByCourseTeacherIdCourses(teacherId,startIndex,pageSize);
    }

    @Override
    public int addClassTime(ClassTime classTime) {
        return courseDao.addClassTime(classTime);
    }
}
