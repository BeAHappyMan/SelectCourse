package com.SelectCourse.controller;

import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.Course;
import com.SelectCourse.service.CourseDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class TeacherController {

    @Autowired
    CourseDaoService courseDaoService;


    @ResponseBody
    @PostMapping("/teacher/showClassSchedule")
    public Result SelectCourse(@RequestBody Map<String,String> map) {
        String teacherId = map.get("teacherId");
        int pageNo = Integer.parseInt(map.get("pageNo"));
        int pageSize = Integer.parseInt(map.get("pageSize"));

        List<Course> courses = courseDaoService.queryAllByCourseTeacherIdCourses(teacherId, (pageNo - 1) * pageSize, pageSize);
        return Result.success("查询成功",courses);
    }
}
