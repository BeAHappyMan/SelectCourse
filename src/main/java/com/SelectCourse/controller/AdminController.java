package com.SelectCourse.controller;

import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.Course;
import com.SelectCourse.service.CourseDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class AdminController {

    @Autowired
    CourseDaoService courseDaoService;

    @PostMapping("/admin/checkCourse")
    public Result checkCourse(@RequestBody Map<String,Object> map){
        String courseId = (String) map.get("courseId");
        Boolean isPass = (Boolean) map.get("isPass");
        int i = courseDaoService.updateCoursePassInt(courseId, isPass ? 1 : 2);
        if(i>0)
            return Result.success("审核成功");
        else
            return Result.success();
    }

    @PostMapping("/admin/showClassSchedule")
    public Result showClassScheduleByCourseLocation(@RequestBody Map<String,String> map){
        String courseLocation = map.get("courseLocation");
        List<Course> courses = courseDaoService.queryByCourseLocation(courseLocation);

        return Result.success("查询成功", courses);
    }
}