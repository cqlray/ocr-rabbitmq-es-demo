package com.jwt.ocrrabbitmqesdemo.common;

import lombok.AllArgsConstructor;

/**
 * @author gqsu
 */
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS("0000","成功"),
    LOGIN_FAILED("0001","登陆失败"),
    NO_PERMISSION("0002","权限不足"),
    SERVER_ERROR("10000","服务器异常"),
    AUTH_ERROR("10001","认证失败"),
    PARAMS_ERROR("10002","参数错误"),
    JSON_PARSE_ERROR("10003","Json解析错误"),
    IO_ERROR("10004","IO异常"),
    CONNECT_TIMEOUT_ERROR("10005","连接超时异常"),
    RPC_ERROR("10006","RPC异常"),
    FEIGN_SERVICE_ERROR("14000","调用其他服务失败"),
    ILLEAGAL_STRING("15001","非法字符串"),
    UNKNOW_ERROR("16000","未知错误"),
    IPC_NOT_EXIST("20001","IPC不存在");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}