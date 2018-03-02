/**
 * @Title: InvalidParamException.java
 * @Package com.eyee.esdata.config.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Ksewen
 * @date 2017年12月22日
 */
package com.enokb.librarian.config.exception;

/**
 * @ClassName: InvalidParamException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ksewen
 * @date 2017年12月22日
 *
 */
public class InvalidParamException extends RuntimeException {

    /**
     * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 创建一个新的实例 InvalidParamException.
     *
     */
    public InvalidParamException() {
        super();
    }

    public InvalidParamException(String message) {
        super(message);
    }
}
