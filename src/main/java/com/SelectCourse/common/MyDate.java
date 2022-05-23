package com.SelectCourse.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyDate {
    /*
    将String类型转为Date
     */
    public static Date toDate(String s) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date newTime = null;
        try {
            newTime = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newTime;

    }

}
