package com.enokb.librarian.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BookStatus {
    DEL(0, "未入库"), REGULAR(1, "在库"), BORROWED(2, "已借出"), APPOINTMENT(3, "预约");

    private int status;
    private String msg;

    BookStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonValue
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonCreator
    public static BookStatus forStatus(int status) {
        for (BookStatus bookStatus : values()) {
            if (status == bookStatus.getStatus()) {
                return bookStatus;
            }
        }
        return null;
    }
}
