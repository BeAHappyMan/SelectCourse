package com.SelectCourse.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassTime {
    private Integer classTimeId;// 时间id
    private String courseId;// 课程号
    private String courseLocation;
    private String classWeek;// 星期
    private String classStartTime;//开始时间
    private String classEndTime;//结束时间
    private Integer classNumber; //课程节数
}
