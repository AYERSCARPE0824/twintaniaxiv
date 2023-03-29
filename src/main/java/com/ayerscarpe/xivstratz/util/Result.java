package com.ayerscarpe.xivstratz.util;

import com.ayerscarpe.xivstratz.util.enums.ResultCodeEnums;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    //构造方法私有化
    private Result(){}
    //成功静态方法
    public static Result success(){
        Result res = new Result();
        res.setSuccess(true);
        res.setCode(ResultCodeEnums.SUCCESS.getCode());
        res.setMessage("登录成功");
        return res;
    }

    public static Result error(){
        Result res = new Result();
        res.setSuccess(false);
        res.setCode(ResultCodeEnums.ERROR.getCode());
        res.setMessage("用户名或密码错误");
        return res;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
