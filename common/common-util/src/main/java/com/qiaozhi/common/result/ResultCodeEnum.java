package com.qiaozhi.common.result;


import lombok.Getter;

/**
 * @author Georg
 */

@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限");


    private final Integer code;
    private final String msg;




    private ResultCodeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
