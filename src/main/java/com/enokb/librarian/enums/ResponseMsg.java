package com.enokb.librarian.enums;

public enum ResponseMsg {
    OK("请求成功");

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
