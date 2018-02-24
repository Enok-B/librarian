package com.enokb.librarian.model;

import com.enokb.librarian.config.constant.ResponseCode;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-02-24 16:32
 **/

public class ResponseModel<T> {
    private int code;
    private String msg;
    private boolean flag;
    private T data;

    /**
     * 创建一个新的实例 ResponseModel.
     */
    public ResponseModel(int code, String msg, boolean flag, T data) {
        this.code = code;
        this.msg = msg;
        this.flag = flag;
        this.data = data;
    }

    /**
     * 创建一个新的实例 ResponseModel.
     */
    public ResponseModel(int code, String msg, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.flag = flag;
    }

    /**
     * 创建一个新的实例 ResponseModel.
     */
    public ResponseModel(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.flag = responseCode.getFlag();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponsePojo [code=" + code + ", msg=" + msg + ", flag=" + flag + ", data=" + data + "]";
    }

}
