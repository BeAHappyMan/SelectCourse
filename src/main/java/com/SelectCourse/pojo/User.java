package com.SelectCourse.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userID;// 用户名Id
    private String userName;// 登录用户名
    private String userNumber;
    private String userPassword;// 登录密码
    private String userType;// 登录用户类型  教师 学生 教务处
}
