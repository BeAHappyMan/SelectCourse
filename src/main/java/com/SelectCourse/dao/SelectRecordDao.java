package com.SelectCourse.dao;

import com.SelectCourse.pojo.SelectRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SelectRecordDao {
    SelectRecord querySelectRecord(SelectRecord selectRecord);
    List<String> querySelectRecordByStudentId(String studentId);
    int addSelectRecord(SelectRecord selectRecord);

    int deleteSelectRecord(SelectRecord selectRecord);
}
