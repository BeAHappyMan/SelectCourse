package com.SelectCourse.service;


import com.SelectCourse.pojo.SelectRecord;

import java.util.List;

public interface SelectRecordDaoService {

    int addSelectRecord(SelectRecord SelectRecord);
    int deleteSelectRecord(SelectRecord selectRecord);
    SelectRecord querySelectRecord(SelectRecord selectRecord);
    List<String> querySelectRecordByStudentId(String studentId);
}
