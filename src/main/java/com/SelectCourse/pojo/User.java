package com.SelectCourse.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;// 用户名Id
    private String userName;// 实际姓名
    private String userPassword;// 登录密码
    private String userType;// 登录用户类型  教师 学生 教务处
}
