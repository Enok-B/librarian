/**
 * @Title: ArticleNotFoundException.java
 * @Package com.eyee.esdata.config.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Ksewen
 * @date 2017年12月22日
 */
package com.enokb.librarian.config.exception;

/**
 * @ClassName: ArticleNotFoundException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ksewen
 * @date 2017年12月22日
 *
 */

public class IncorrectStatusException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 创建一个新的实例 IncorrectStatusException.
     *
     */
    public IncorrectStatusException() {
        super();
    }

    /**
     * 创建一个新的实例 IncorrectStatusException.
     *
     */
    public IncorrectStatusException(String message) {
        super(message);
    }
}
