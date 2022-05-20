package com.SelectCourse.controller;

import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.ClassTime;
import com.SelectCourse.pojo.Course;
import com.SelectCourse.service.CourseDaoService;
import org.apache.commons.lang3.RandomStringUtils;
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
    public Result showClassSchedule(@RequestBody Map<String,String> map) {
        String teacherId = map.get("teacherId");
        int pageNo = Integer.parseInt(map.get("pageNo"));
        int pageSize = Integer.parseInt(map.get("pageSize"));

        List<Course> courses = courseDaoService.queryAllByCourseTeacherIdCourses(teacherId, (pageNo - 1) * pageSize, pageSize);
        return Result.success("查询成功",courses);
    }

    @ResponseBody
    @PostMapping("/teacher/addCourse")
    public Result addCourse(@RequestBody Map<String,Object> map) {
        String courseTeacherId = (String) map.get("courseTeacherId");
        String courseName = (String) map.get("courseName");
        Integer courseCredit = (Integer) map.get("courseCredit");
        Integer courseMaxStudentNumber = (Integer) map.get("courseMaxStudentNumber");

        List<String> courseIds = courseDaoService.getCourseId();
        String courseId;
        while(true) {
            courseId = RandomStringUtils.randomAlphanumeric(5);
            if(!courseIds.contains(courseId))
                break;
        }
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseCredit(courseCredit);
        course.setCourseTeacherId(courseTeacherId);
        course.setCoursePass(0);
        course.setCourseName(courseName);
        course.setCourseMaxStudentNumber(courseMaxStudentNumber);
        courseDaoService.addCourse(course);
        List<Map<String,Object>> courseTimes = (List<Map<String, Object>>) map.get("courseTime");
        for (Map<String, Object> map2 : courseTimes) {
            String courseLocation = (String) map2.get("courseLocation");
            String classWeek = (String) map2.get("classWeek");
            String classStartTime = (String) map2.get("classStartTime");
            String classEndTime = (String) map2.get("classEndTime");
//            int classNumber = (int) map2.get("classNumber");
            ClassTime classTime = new ClassTime();
            classTime.setClassEndTime(classEndTime);
            classTime.setClassStartTime(classStartTime);
            classTime.setCourseId(courseId);
            classTime.setClassWeek(classWeek);
//            classTime.setClassNumber(classNumber);
            classTime.setCourseLocation(courseLocation);
            courseDaoService.addClassTime(classTime);
        }

        return Result.success("成功");
    }


}
