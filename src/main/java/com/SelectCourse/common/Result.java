package com.SelectCourse.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int errorCode;
    private String message;
    private Object data;

    public static Result success(){
        return new Result(0,"",null);
    }

    public static Result success(Object data){
        return new Result(0,"",data);
    }


    public static Result success(String message){
        return new Result(0,message,null);
    }
    public static Result success(String message,Object data){
        return new Result(0,message,data);
    }


    public static Result error(String message){
        return new Result(1,message,null);
    }

}
