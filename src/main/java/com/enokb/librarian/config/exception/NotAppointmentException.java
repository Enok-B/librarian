package com.enokb.librarian.config.exception;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018/5/6 下午8:05
 **/

public class NotAppointmentException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 创建一个新的实例 InvalidParamException.
     *
     */
    public NotAppointmentException() {
        super();
    }

    public NotAppointmentException(String message) {
        super(message);
    }
}
