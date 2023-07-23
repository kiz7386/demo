package com.example.demo.response;

import com.example.demo.constant.ResMsg;
import com.example.demo.constant.ResponseCodeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T>{

    private int code;
    private String msg;
    private T data;

    public Response() {
    }

    public Response(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static <T> Response<T> just(ResMsg resMsg, int value, T data) {
        return new Response<>(resMsg.getMessage(), value, data);
    }

    public static <T> Response<T> success(ResMsg resMsg, T data) {
        return just(resMsg, ResponseCodeEnum.SUCCESS.getValue(), data);
    }

    public static <T> Response<T> success(T data) {
        return just(ResMsg.GET_DATA_SUCCESS, ResponseCodeEnum.SUCCESS.getValue(), data);
    }

    public static <T> Response<T> fail(T data) {
        return just(ResMsg.FAIL, ResponseCodeEnum.FAIL.getValue(), data);
    }

    public static <T> Response<T> fail(ResMsg resMsg) {
        return just(resMsg, ResponseCodeEnum.FAIL.getValue(), null);
    }

    public static <T> Response<T> fail(ResMsg resMsg, T data) {
        return just(resMsg, ResponseCodeEnum.FAIL.getValue(), data);
    }

    public static <T> Response<T> error() {
        return just(ResMsg.SYSTEM_ERROR, ResponseCodeEnum.SYSTEM_ERROR.getValue(), null);
    }

    public static <T> Response<T> fail(String msg){
        return new Response<>(msg,-1,null);
    }

}
