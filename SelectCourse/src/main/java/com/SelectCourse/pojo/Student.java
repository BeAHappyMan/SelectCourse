package com.SelectCourse.pojo;

public class Student {
    private int studentID;// 学生id
    private String studentName;// 学生姓名
    private String studentNumber;// 学号
    private String studentAge;// 学生年龄
    private String studentClass;//学生班级

    public Student() {
    }

    public Student(int studentID, String studentName, String studentNumber, String studentAge, String studentClass) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentAge = studentAge;
        this.studentClass = studentClass;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
