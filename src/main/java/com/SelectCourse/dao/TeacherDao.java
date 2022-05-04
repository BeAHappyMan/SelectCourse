package com.SelectCourse.dao;

import com.SelectCourse.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherDao {
    int addTeacher(Teacher teacher);
}
