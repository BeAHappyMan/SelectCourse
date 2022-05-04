package com.SelectCourse.service.Impl;

import com.SelectCourse.dao.StudentDao;
import com.SelectCourse.pojo.Student;
import com.SelectCourse.service.StudentDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDaoServiceImpl implements StudentDaoService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }
}
