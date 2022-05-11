package com.SelectCourse.controller;


import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.SelectRecord;
import com.SelectCourse.service.CourseDaoService;
import com.SelectCourse.service.SelectRecordDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
