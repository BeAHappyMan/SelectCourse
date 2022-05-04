package com.SelectCourse.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentID;// 学生id
    private String studentName;// 学生姓名
    private String studentNumber;// 学号
    private String studentAge;// 学生年龄
    private String studentClass;//学生班级
}
