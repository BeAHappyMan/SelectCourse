package com.SelectCourse.controller;


import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.Course;
import com.SelectCourse.pojo.SelectRecord;
import com.SelectCourse.service.CourseDaoService;
import com.SelectCourse.service.SelectRecordDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    SelectRecordDaoService selectRecordDaoService;

    @Autowired
    CourseDaoService courseDaoService;


    @ResponseBody
    @PostMapping("/student/selectCourse")
    public Result SelectCourse(@RequestBody  Map<String,String> map){
        System.out.println(map);
        String studentId = map.get("studentId");
        String courseId = map.get("courseId");
//        System.out.println(studentId);
//        System.out.println(courseId);

        int courseMaxStudentNumber = courseDaoService.getCourseMaxStudentNumber(courseId);
        int courseStudentNumber = courseDaoService.getCourseStudentNumber(courseId);
        System.out.println(courseStudentNumber);
        System.out.println(courseMaxStudentNumber);

        if(courseMaxStudentNumber<=courseStudentNumber)
            return Result.error("容量已满");

        SelectRecord selectRecord = new SelectRecord();
        selectRecord.setStudentId(studentId);
        selectRecord.setCourseId(courseId);
        int i = selectRecordDaoService.addSelectRecord(selectRecord);
        if(i>0) {
            courseDaoService.increaseCourseStudentNumber(courseId);
            return Result.success("选课成功");
        }
        else
            return Result.error("选课失败");
    }

    @ResponseBody
    @PostMapping("/student/dropCourse")
    public Result dropCourse(@RequestBody Map<String,String> map){
        String studentId = map.get("studentId");
        String courseId = map.get("courseId");

        SelectRecord selectRecord = new SelectRecord();
        selectRecord.setStudentId(studentId);
        selectRecord.setCourseId(courseId);
        int i = selectRecordDaoService.deleteSelectRecord(selectRecord);
        System.out.println(i);
        if(i>0) {
            courseDaoService.decreaseCourseStudentNumber(courseId);
            return Result.success("退课成功");
        }
        else
            return Result.error("退课失败");
    }

    @ResponseBody
    @PostMapping("/student/showCourses")
    public Result showCourses(@RequestBody Map<String,Object> map){
        String studentId = (String) map.get("studentId");
        int pageSize = (int) map.get("pageSize");
        int pageNo = (int) map.get("pageNo");
        List<Course> courses = courseDaoService.queryAllCourses((pageNo-1)*pageSize,pageSize);

        SelectRecord selectRecord = new SelectRecord();
        selectRecord.setStudentId(studentId);
        for (Course course : courses) {
            selectRecord.setCourseId(course.getCourseId());
            if(selectRecordDaoService.querySelectRecord(selectRecord)!=null)
                course.setIsSelected(true);
            else
                course.setIsSelected(false);
        }
        return Result.success("成功",courses);
    }

    @ResponseBody
    @PostMapping("/student/showClassSchedule")
    public Result showClassSchedule(@RequestBody Map<String,String> map) {
        String studentId = map.get("studentId");
        List<String> courseIds = selectRecordDaoService.querySelectRecordByStudentId(studentId);
        List<Course> courses  = new ArrayList<>();
        for (String courseId : courseIds) {
            courses.add(courseDaoService.queryCourseByCourseId(courseId));
        }
        return Result.success("成功",courses);
    }
}
