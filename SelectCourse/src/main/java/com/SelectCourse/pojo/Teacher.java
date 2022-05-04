package com.SelectCourse.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int teacherID;// 教师id
    private String teacherName;// 教师姓名
    private String teacherNumber;// 教师工号
}
