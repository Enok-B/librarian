package com.enokb.librarian.config.exception;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 17:05
 **/

public class RegisterFailedException extends RuntimeException {
    /**
     * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
     */
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
