package com.enokb.librarian.dto;

import com.enokb.librarian.enums.ResponseMsg;

import java.util.Date;

/**
 * @program: librarian
 * @description: response base dto
 * @author: ksewen
 * @create: 2018-03-03 11:52
 **/

public class ResponseDto<T> {

    public ResponseDto(T data) {
        this.data = data;
        this.serverTime = new Date();
    }

    public ResponseDto(String msg, T data) {
        this.msg = msg;
        this.data = data;
        this.serverTime = new Date();
    }

    private String msg;
    private T data;
    private Date serverTime;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "data=" + data +
                ", serverTime=" + serverTime +
                '}';
    }

    public static <T> ResponseDto<T> ok() {
        return new ResponseDto<>(ResponseMsg.OK.getMsg(),null);
    }

    public static <T> ResponseDto<T> ok(T data) {
        return new ResponseDto<>(ResponseMsg.OK.getMsg(), data);
    }

    public static <T> ResponseDto<T> badRequest() {
        return new ResponseDto<>(ResponseMsg.BAD_REQUEST.getMsg(),null);
    }

    public static <T> ResponseDto<T> badRequest(T data) {
        return new ResponseDto<>(ResponseMsg.BAD_REQUEST.getMsg(),data);
    }

    public static <T> ResponseDto<T> notFound() {
        return new ResponseDto<>(ResponseMsg.NOT_FOUND.getMsg(),null);
    }

    public static <T> ResponseDto<T> notFound(T data) {
        return new ResponseDto<>(ResponseMsg.NOT_FOUND.getMsg(),data);
    }

    public static <T> ResponseDto<T> invalidParam() {
        return new ResponseDto<>(ResponseMsg.INVALID_PARAM.getMsg(),null);
    }

    public static <T> ResponseDto<T> invalidParam(T data) {
        return new ResponseDto<>(ResponseMsg.INVALID_PARAM.getMsg(),data);
    }
}
