package com.enokb.librarian.dto;

/**
 * @program: librarian
 * @description: response base dto
 * @author: ksewen
 * @create: 2018-03-03 11:52
 **/

public class ResponseDto<T> {

    public ResponseDto(T data) {
        this.data = data;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "data=" + data +
                '}';
    }
}
