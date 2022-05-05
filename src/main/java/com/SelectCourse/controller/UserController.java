package com.SelectCourse.controller;

import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.Student;
import com.SelectCourse.pojo.Teacher;
import com.SelectCourse.pojo.User;
import com.SelectCourse.service.StudentDaoService;
import com.SelectCourse.service.TeacherDaoService;
import com.SelectCourse.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private StudentDaoService studentDaoService;
    @Autowired
    private TeacherDaoService teacherDaoService;

    @RequestMapping(value = "/login", produces="application/json")
    public Result userLogin(HttpServletRequest request){
        // 获取登录信息
        String userNumber = request.getParameter("userNumber");
        String userPassword = request.getParameter("userPassword");
        String userType = request.getParameter("userType");
        System.out.println(userNumber+userPassword+userType);
        User user = userDaoService.queryUserByUserNumber(userNumber);
        if(user==null)
            return Result.error("用户不存在");
        if(!user.getUserPassword().equals(userPassword))
            return Result.error("密码错误");
        else
            return Result.success("登录成功",user);
    }
    @RequestMapping("/Register")
    public Result userRegister(HttpServletRequest request){
        String userNumber = request.getParameter("userNumber");
        String userName= request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userType = request.getParameter("userType");
        User user = userDaoService.queryUserByUserNumber(userNumber);
        if(user!=null)
            return Result.error("用户已经存在");
        User user1 = new User();
        user1.setUserName(userName);
        user1.setUserNumber(userNumber);
        user1.setUserType(userType);
        user1.setUserPassword(userPassword);
        userDaoService.addUser(user1);

        if(userType.equals("学生")) {
            Student student = new Student();
            student.setStudentName(userName);
            student.setStudentNumber(userNumber);
            String studentClass = request.getParameter("studentClass");
            student.setStudentClass(studentClass);
            int res = studentDaoService.addStudent(student);
            if (res > 0)
                return Result.success("学生注册成功", student);
            else {
                userDaoService.deleteUser(userNumber);
                return Result.success("注册失败");
            }
        }
        if(userType.equals("老师")) {
            Teacher teacher = new Teacher();
            teacher.setTeacherName(userName);
            teacher.setTeacherNumber(userNumber);

            int res = teacherDaoService.addTeacher(teacher);
            if (res > 0)
                return Result.success("老师注册成功", teacher);
            else {
                userDaoService.deleteUser(userNumber);
                return Result.success("注册失败");
            }
        }
        return Result.error("userType错误");
    }

}
