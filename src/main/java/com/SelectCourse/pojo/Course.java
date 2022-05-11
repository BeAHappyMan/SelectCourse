package com.SelectCourse.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String courseId;// 课程号
    private String courseName;// 课程名
//    private String courseInformation;// 课程信息
    private Integer courseMaxStudentNumber;// 选课最大人数
    private Integer courseStudentNumber;// 已选人数
    private String courseTeacherId;// 课程老师工号
    private String teacherName;
    private Boolean isSelected;
    private Integer coursePass;
    private Integer courseCredit;
    private List<ClassTime> classTime;
}
