package com.enokb.librarian.enums;

public enum ResponseMsg {
    OK("请求成功"),
    BAD_REQUEST("非法的请求"),
    NOT_FOUND("找不到资源"),
    INVALID_PARAM("错误的参数");

    private String msg;

    ResponseMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
