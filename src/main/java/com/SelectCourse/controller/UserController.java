package com.SelectCourse.controller;

import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.Student;
import com.SelectCourse.pojo.Teacher;
import com.SelectCourse.pojo.User;
import com.SelectCourse.service.StudentDaoService;
import com.SelectCourse.service.TeacherDaoService;
import com.SelectCourse.service.UserDaoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private StudentDaoService studentDaoService;
    @Autowired
    private TeacherDaoService teacherDaoService;

    @ResponseBody
    @PostMapping("/login")
    public Result userLogin(@RequestBody User user2){

        // 获取登录信息
//        String userId = jsonObject.getString("userId");
        String userId = user2.getUserId();
//        String userPassword = jsonObject.getString("userPassword");
        String userPassword = user2.getUserPassword();
//        String userType = map.get("userType");
//        System.out.println(userId+userPassword);
        User user = userDaoService.queryUserByUserId(userId);
        if(user==null)
            return Result.error("用户不存在");
        if(!user.getUserPassword().equals(userPassword))
            return Result.error("密码错误");
        else
          return Result.success("登录成功",user);
    }

    @ResponseBody
    @PostMapping("/register")
    public Result userRegister(@RequestBody Map<String,String> map){
        System.out.println(map);
        String userId = map.get("userId");
        String userName= map.get("userName");
        String userPassword = map.get("userPassword");
        String userType = map.get("userType");
        User user = userDaoService.queryUserByUserId(userId);
        if(user!=null)
            return Result.error("用户已经存在");

        User user1 = new User();
        user1.setUserName(userName);
        user1.setUserId(userId);
        user1.setUserType(userType);
        user1.setUserPassword(userPassword);
        userDaoService.addUser(user1);

        if(userType.equals("学生")) {
            Student student = new Student();
            student.setStudentName(userName);
            student.setStudentId(userId);
            String studentClass = map.get("studentClass");
            student.setStudentClass(studentClass);
            int res = studentDaoService.addStudent(student);
            if (res > 0)
                return Result.success("学生注册成功", student);
            else {
                userDaoService.deleteUser(userId);
                return Result.success("注册失败");
            }
        }
        if(userType.equals("教师")) {
            Teacher teacher = new Teacher();
            teacher.setTeacherName(userName);
            teacher.setTeacherId(userId);

            int res = teacherDaoService.addTeacher(teacher);
            if (res > 0)
                return Result.success("教师注册成功", teacher);
            else {
                userDaoService.deleteUser(userId);
                return Result.success("注册失败");
            }
        }
        return Result.error("userType错误");
    }

}
