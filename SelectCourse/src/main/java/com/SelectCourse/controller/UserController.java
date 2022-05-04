package com.SelectCourse.controller;

import com.SelectCourse.common.Constants;
import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.User;
import com.SelectCourse.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping("/login")
    public Result userLogin(HttpServletRequest request){
        // 获取登录信息
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userType = request.getParameter("userType");
        User user = userDaoService.userLogin(userName);
        if(user==null)
            return Result.error(Constants.CODE_400,"用户不存在");
        if(!user.getUserPassword().equals(userPassword))
            return Result.error(Constants.CODE_400,"密码错误");
        else
            return Result.success(userType);
    }

}
