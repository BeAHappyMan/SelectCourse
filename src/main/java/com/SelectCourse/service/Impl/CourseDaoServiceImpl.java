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
    public List<Course> queryAllCourses() {
        return courseDao.queryAllCourses();
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }
}
