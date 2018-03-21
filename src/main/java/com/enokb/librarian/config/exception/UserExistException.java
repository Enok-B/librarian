package com.enokb.librarian.config.exception;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:44
 **/

public class UserExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 创建一个新的实例 ResourceNotFoundException.
     *
     */
    public UserExistException() {
        super();
    }

    /**
     * 创建一个新的实例 ResourceNotFoundException.
     *
     */
    public UserExistException(String message) {
        super(message);
    }
}
