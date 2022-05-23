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
/*
教务处
 */
public class AdminController {

    @Autowired
    CourseDaoService courseDaoService;

    // 删除课程
    @PostMapping("/admin/deleteCourse")
    public Result deleteCourse(@RequestBody Map<String, String> map) {
        String courseId = (String) map.get("courseId");

        courseDaoService.deleteByCourseId(courseId);
        courseDaoService.deleteClassTimeByCourseId(courseId);

        return Result.success("删除成功");
    }

    // 审核课程
    @PostMapping("/admin/checkCourse")
    public Result checkCourse(@RequestBody Map<String, Object> map) {
        String courseId = (String) map.get("courseId");
        Boolean isPass = (Boolean) map.get("isPass");

        // 更新审核状态
        int i = courseDaoService.updateCoursePassInt(courseId, isPass ? 1 : 2);
        if (i > 0)
            return Result.success("审核成功");
        else
            return Result.error("审核失败");
    }

    // 根据教室查询课程
    @PostMapping("/admin/showClassSchedule")
    public Result showClassScheduleByCourseLocation(@RequestBody Map<String, String> map) {
        String courseLocation = map.get("courseLocation");

        List<Course> courses = courseDaoService.queryByCourseLocation(courseLocation);

        return Result.success("查询成功", courses);
    }

    // 查询所有课程
    @PostMapping("/admin/showAllCourse")
    public Result showAllCourse(@RequestBody Map<String, Integer> map) {
        int pageNo = map.get("pageNo");
        int pageSize = map.get("pageSize");

        List<Course> courses = courseDaoService.queryAllCourses2((pageNo - 1) * pageSize, pageSize);

        return Result.success("查询成功", courses);
    }
}