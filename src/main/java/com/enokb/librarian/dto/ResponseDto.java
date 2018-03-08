package com.enokb.librarian.dto;

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

    @Override
    public String toString() {
        return "ResponseDto{" +
                "data=" + data +
                ", serverTime=" + serverTime +
                '}';
    }

    public static <T> ResponseDto<T> ok() {
        return new ResponseDto<>(null);
    }

    public static <T> ResponseDto<T> ok(T data) {
        return new ResponseDto<>(data);
    }
}
