package com.example.demo.constant;

public enum ResponseCodeEnum {
    //操作成功
    SUCCESS(1),
    //用户未登入
    NOLOGIN(0),
    //验证失败
    FAIL(-1),
    //系统错误 catch
    SYSTEM_ERROR(-2);

    private int value;
    private ResponseCodeEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getValueStr() {
        return String.valueOf(value);
    }
}
