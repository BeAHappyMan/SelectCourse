package com.SelectCourse.pojo;

public class Course {
    private int courseID;// 课程id
    private String courseName;// 课程名
    private String courseNumber;// 课程号
    private String courseInformation;// 课程信息
    private int courseMaxStudentNumber;// 选课最大人数
    private int courseStudentNumber;// 已选人数
    private int courseTeacherNumber;// 课程老师工号

    public Course() {
    }

    public Course(int courseID, String courseName, String courseNumber, String courseInformation, int courseMaxStudentNumber, int courseStudentNumber, int courseTeacherNumber) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.courseInformation = courseInformation;
        this.courseMaxStudentNumber = courseMaxStudentNumber;
        this.courseStudentNumber = courseStudentNumber;
        this.courseTeacherNumber = courseTeacherNumber;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", courseInformation='" + courseInformation + '\'' +
                ", courseMaxStudentNumber=" + courseMaxStudentNumber +
                ", courseStudentNumber=" + courseStudentNumber +
                ", courseTeacherNumber=" + courseTeacherNumber +
                '}';
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseInformation() {
        return courseInformation;
    }

    public void setCourseInformation(String courseInformation) {
        this.courseInformation = courseInformation;
    }

    public int getCourseMaxStudentNumber() {
        return courseMaxStudentNumber;
    }

    public void setCourseMaxStudentNumber(int courseMaxStudentNumber) {
        this.courseMaxStudentNumber = courseMaxStudentNumber;
    }

    public int getCourseStudentNumber() {
        return courseStudentNumber;
    }

    public void setCourseStudentNumber(int courseStudentNumber) {
        this.courseStudentNumber = courseStudentNumber;
    }

    public int getCourseTeacherNumber() {
        return courseTeacherNumber;
    }

    public void setCourseTeacherNumber(int courseTeacherNumber) {
        this.courseTeacherNumber = courseTeacherNumber;
    }
}
