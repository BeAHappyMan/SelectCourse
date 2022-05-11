package com.SelectCourse.service.Impl;

import com.SelectCourse.dao.SelectRecordDao;
import com.SelectCourse.pojo.SelectRecord;
import com.SelectCourse.service.SelectRecordDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectRecordDaoServiceImpl implements SelectRecordDaoService {

    @Autowired
    SelectRecordDao selectRecordDao;

    @Override
    public int addSelectRecord(SelectRecord selectRecord) {
        return selectRecordDao.addSelectRecord(selectRecord);
    }

    @Override
    public int deleteSelectRecord(SelectRecord selectRecord) {
        return selectRecordDao.deleteSelectRecord(selectRecord);
    }
}
