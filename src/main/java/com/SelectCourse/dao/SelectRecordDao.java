package com.SelectCourse.dao;

import com.SelectCourse.pojo.SelectRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SelectRecordDao {

    int addSelectRecord(SelectRecord selectRecord);

    int deleteSelectRecord(SelectRecord selectRecord);
}
