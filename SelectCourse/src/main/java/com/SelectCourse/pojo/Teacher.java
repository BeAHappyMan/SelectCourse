package com.SelectCourse.pojo;

public class Teacher {
    private int teacherID;// 教师id
    private String teacherName;// 教师姓名
    private String teacherNumber;// 教师工号

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", teacherName='" + teacherName + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                '}';
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public Teacher() {
    }

    public Teacher(int teacherID, String teacherName, String teacherNumber) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherNumber = teacherNumber;
    }
}
