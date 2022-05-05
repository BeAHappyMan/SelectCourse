package com.SelectCourse.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassTime {
    private int ClassTimeID;// 时间id
    private String courseNumber;// 课程号
    private String courseLocation;
    private String classWeekend;// 星期
    private String classStartTime;//
    private String classEndTime;
    private int classNumber; //课程节数
}
