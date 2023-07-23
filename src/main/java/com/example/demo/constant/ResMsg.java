package com.example.demo.constant;

import lombok.Getter;

/**
 * 返回訊息分類
 * <p>
 * 2*** : 成功，操作被成功接收並處理
 * 4*** : 客戶端錯誤，請求包含參數錯誤或無法完成請求
 * 5*** : 服務器錯誤，服務器在處理請求的過程中出錯
 */
@Getter
public enum ResMsg {
    /** OK */
    OK(2000, "OK"),
    /** 成功 */
    SUCCESS(2001, "成功"),
    /** 新增成功 */
    ADD_SUCCESS(2002, "新增成功"),
    /** 数据获取成功 */
    GET_DATA_SUCCESS(2003, "数据获取成功"),
    /** 导出成功 */
    EXPORT_SUCCESS(2004, "导出成功"),
    /** 失败 */
    FAIL(4001, "失败"),
    /** 新增失败 */
    ADD_FAIL(4002, "新增失败"),
    /** 格式错误 */
    FORMAT_ERROR(4003, "格式错误"),
    /** 传入参数错误 */
    PARAM_ERROR(4004, "传入参数错误"),
    /** 重复提交 */
    REPEATED_SUBMIT(4005, "重复提交"),
    /** 权限不足 */
    INSUFFICIENT_PERMISSIONS(4006, "权限不足"),
    /** 用户未登入 */
    USER_NOT_LOGIN(4007, "用户未登入"),
    /** 请输入正确名称 */
    /** 系统错误，请稍后重试 */
    SYSTEM_ERROR(5001, "系统错误，请稍后重试");

    private final int code;
    private final String message;

    ResMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
