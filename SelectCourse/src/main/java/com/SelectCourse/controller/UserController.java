package com.SelectCourse.controller;

import com.SelectCourse.pojo.User;
import com.SelectCourse.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping("/login")
    public String userLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session){

        // 获取登录信息
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userType = request.getParameter("userType");
        User user =new User(userName,userPassword,userType);


    }

}
