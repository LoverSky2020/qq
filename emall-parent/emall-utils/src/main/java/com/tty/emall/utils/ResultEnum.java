package com.tty.emall.utils;

/**
 * @author tty
 * @create 2020-07-22-17:18
 */
public enum ResultEnum {

    SUCCESS("10000", "success"),
    ERROR("10001", "error");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
