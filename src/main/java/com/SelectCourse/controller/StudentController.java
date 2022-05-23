package com.SelectCourse.controller;


import com.SelectCourse.common.MyDate;
import com.SelectCourse.common.Result;
import com.SelectCourse.pojo.ClassTime;
import com.SelectCourse.pojo.Course;
import com.SelectCourse.pojo.SelectRecord;
import com.SelectCourse.service.CourseDaoService;
import com.SelectCourse.service.SelectRecordDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
学生
 */
@RestController
@RequestMapping
public class StudentController {

    @Autowired
    SelectRecordDaoService selectRecordDaoService;

    @Autowired
    CourseDaoService courseDaoService;


    /*
    选课
     */
    @ResponseBody
    @PostMapping("/student/selectCourse")
    public Result SelectCourse(@RequestBody Map<String, String> map) {
        System.out.println(map);
        String studentId = map.get("studentId");
        String courseId = map.get("courseId");
//        System.out.println(studentId);
//        System.out.println(courseId);

        int courseMaxStudentNumber = courseDaoService.getCourseMaxStudentNumber(courseId);
        int courseStudentNumber = courseDaoService.getCourseStudentNumber(courseId);
//        System.out.println(courseStudentNumber);
//        System.out.println(courseMaxStudentNumber);

        if (courseMaxStudentNumber <= courseStudentNumber) return Result.error("容量已满");

        SelectRecord selectRecord = new SelectRecord();
        selectRecord.setStudentId(studentId);
        selectRecord.setCourseId(courseId);

        // 查询选课记录是否存在
        SelectRecord selectRecord1 = selectRecordDaoService.querySelectRecord(selectRecord);

        if (selectRecord1 != null) return Result.error("课程已选择");
        int i = selectRecordDaoService.addSelectRecord(selectRecord);
        if (i > 0) {

            // 更新选课学生人数
            courseDaoService.increaseCourseStudentNumber(courseId);
            return Result.success("选课成功");
        } else return Result.error("选课失败");
    }

    /*
    退课
     */
    @ResponseBody
    @PostMapping("/student/dropCourse")
    public Result dropCourse(@RequestBody Map<String, String> map) {
        String studentId = map.get("studentId");
        String courseId = map.get("courseId");

        SelectRecord selectRecord = new SelectRecord();
        selectRecord.setStudentId(studentId);
        selectRecord.setCourseId(courseId);
        // 删除选课记录
        int i = selectRecordDaoService.deleteSelectRecord(selectRecord);
        System.out.println(i);
        if (i > 0) {
            // 更新选课人数
            courseDaoService.decreaseCourseStudentNumber(courseId);
            return Result.success("退课成功");
        } else return Result.error("退课失败");
    }

    /*
    查询所有课程，设置是否选择以及是否冲突状态
     */
    @ResponseBody
    @PostMapping("/student/showCourses")
    public Result showCourses(@RequestBody Map<String, Object> map) {
        String studentId = (String) map.get("studentId");
        int pageSize = (int) map.get("pageSize");
        int pageNo = (int) map.get("pageNo");
        List<Course> courses = courseDaoService.queryAllCourses((pageNo - 1) * pageSize, pageSize);
        System.out.println(courses);
        SelectRecord selectRecord = new SelectRecord();
        selectRecord.setStudentId(studentId);
        List<List<String>> t = new ArrayList<>();

        // 判断是否选了该课程
        for (Course course : courses) {
            selectRecord.setCourseId(course.getCourseId());
            if (selectRecordDaoService.querySelectRecord(selectRecord) != null) {
                course.setIsSelected(true);
                List<String> temp = new ArrayList<>();
                for (ClassTime classTime : course.getClassTime()) {
//                    temp.add(course.getCourseId());
                    temp.add(classTime.getClassWeek());
                    temp.add(classTime.getClassStartTime());
                    temp.add(classTime.getClassEndTime());
                }
//                mm.put(course.getCourseId(),temp);
                t.add(temp);
            } else course.setIsSelected(false);
        }

        // 判断时间是否冲突
        for (Course course : courses) {
            if (!course.getIsSelected()) {
                boolean flag = true;
                for (ClassTime classTime : course.getClassTime()) {
                    String week = classTime.getClassWeek();
                    String start = classTime.getClassStartTime();
                    String end = classTime.getClassEndTime();
                    for (List<String> strings : t) {
                        if (strings.get(0).equals(week)) {
                            System.out.println(MyDate.toDate(strings.get(1)).compareTo(MyDate.toDate(end)));
                            System.out.println(MyDate.toDate(strings.get(2)).compareTo(MyDate.toDate(start)));
                            if (MyDate.toDate(strings.get(1)).compareTo(MyDate.toDate(end)) <= 0 && MyDate.toDate(strings.get(2)).compareTo(MyDate.toDate(start)) >= 0) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (!flag) break;
                }
                System.out.println(flag);
                if (!flag) course.setIsConflict(true);
                else course.setIsConflict(false);
            }
        }
        return Result.success("成功", courses);
    }

    /*
    查询已选课程
     */
    @ResponseBody
    @PostMapping("/student/showClassSchedule")
    public Result showClassSchedule(@RequestBody Map<String, String> map) {
        String studentId = map.get("studentId");
        List<String> courseIds = selectRecordDaoService.querySelectRecordByStudentId(studentId);
        List<Course> courses = new ArrayList<>();
        for (String courseId : courseIds) {
            courses.add(courseDaoService.queryCourseByCourseId(courseId));
        }
        return Result.success("成功", courses);
    }
}
