package com.SelectCourse.service.Impl;

import com.SelectCourse.dao.TeacherDao;
import com.SelectCourse.pojo.Teacher;
import com.SelectCourse.service.TeacherDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherDaoServiceImpl implements TeacherDaoService {

    @Autowired
    TeacherDao teacherDao;

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }
}
