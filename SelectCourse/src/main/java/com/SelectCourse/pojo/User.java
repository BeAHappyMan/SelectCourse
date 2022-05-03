package com.SelectCourse.pojo;

public class User {
    private int userID;// 用户名Id
    private String userName;// 登录用户名
    private String userPassword;// 登录密码
    private String userType;// 登录用户类型  教师 学生 教务处

    public User() {
    }

    public User(String userName, String userPassword, String userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public User(int userID, String userName, String userPassword, String userType) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }
}
