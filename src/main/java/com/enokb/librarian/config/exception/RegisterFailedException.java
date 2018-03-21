package com.enokb.librarian.config.exception;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 17:05
 **/

public class RegisterFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 创建一个新的实例 InvalidParamException.
     */
    public RegisterFailedException() {
        super();
    }

    public RegisterFailedException(String message) {
        super(message);
    }
}
