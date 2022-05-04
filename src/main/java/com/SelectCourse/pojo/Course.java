package com.SelectCourse.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseID;// 课程id
    private String courseName;// 课程名
    private String courseNumber;// 课程号
    private String courseInformation;// 课程信息
    private int courseMaxStudentNumber;// 选课最大人数
    private int courseStudentNumber;// 已选人数
    private int courseTeacherNumber;// 课程老师工号
    private ClassTime classTime;
}
