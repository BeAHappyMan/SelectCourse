package com.SelectCourse.pojo;

public class ClassTime {
    private int timeID;// 时间id
    private String courseNumber;// 课程号
    private String courseLocation;
    private int classWeekend;// 星期
    private int classStartTime;//
    private int classEndTime;
    private int classNumber; //课程节数

    @Override
    public String toString() {
        return "ClassTime{" +
                "timeID=" + timeID +
                ", courseNumber='" + courseNumber + '\'' +
                ", courseLocation='" + courseLocation + '\'' +
                ", classWeekend=" + classWeekend +
                ", classStartTime=" + classStartTime +
                ", classEndTime=" + classEndTime +
                ", classNumber=" + classNumber +
                '}';
    }

    public int getTimeID() {
        return timeID;
    }

    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public int getClassWeekend() {
        return classWeekend;
    }

    public void setClassWeekend(int classWeekend) {
        this.classWeekend = classWeekend;
    }

    public int getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(int classStartTime) {
        this.classStartTime = classStartTime;
    }

    public int getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(int classEndTime) {
        this.classEndTime = classEndTime;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public ClassTime() {
    }

    public ClassTime(int timeID, String courseNumber, String courseLocation, int classWeekend, int classStartTime, int classEndTime, int classNumber) {
        this.timeID = timeID;
        this.courseNumber = courseNumber;
        this.courseLocation = courseLocation;
        this.classWeekend = classWeekend;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classNumber = classNumber;
    }
}
