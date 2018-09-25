package com.zhlzzz.tool.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setCode(100);
        result.setMessage("系统错误");
        return result;
    }

    public static Result fail(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
