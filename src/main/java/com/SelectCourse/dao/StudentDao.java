package com.SelectCourse.dao;

import com.SelectCourse.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentDao {

    int addStudent(Student student);
}
