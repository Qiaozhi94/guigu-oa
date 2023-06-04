package com.qiaozhi.common.result;


import lombok.Data;

/**
 * @author Georg
 */
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    private Result(){}


    //封装返回是数据
    public static <T> Result <T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();

        //封装数据
        if (body != null){
            result.setData(body);
        }
        //状态码
        result.setCode(resultCodeEnum.getCode());
        //返回信息
        result.setMsg(resultCodeEnum.getMsg());
        return result;
    }


    //成功方法
    public static <T> Result<T> success(){
        return build(null, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> success(T data){
        return build(data, ResultCodeEnum.SUCCESS);
    }

    //失败方法
    public static <T> Result<T> fail(){
        return build(null, ResultCodeEnum.FAIL);
    }

    public static <T> Result<T> fail(T data){
        return build(data, ResultCodeEnum.FAIL);
    }

    public Result<T> message(String msg){
        this.setMsg(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}
