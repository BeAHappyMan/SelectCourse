package com.SelectCourse.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
errorCode:0表示操作成功，否则失败
message:一段文字描述
data:前端所需要的数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int errorCode;
    private String message;
    private Object data;

    public static Result success() {
        return new Result(0, "", null);
    }

    public static Result success(String message) {
        return new Result(0, message, null);
    }

    public static Result success(String message, Object data) {
        return new Result(0, message, data);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }

}
