package com.SelectCourse.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentId;// 学号
    private String studentName;// 学生姓名
    private String studentClass;//学生班级
}
