package com.SelectCourse.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassTime {
    private int timeID;// 时间id
    private String courseNumber;// 课程号
    private String courseLocation;
    private int classWeekend;// 星期
    private int classStartTime;//
    private int classEndTime;
    private int classNumber; //课程节数
}
