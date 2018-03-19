package com.enokb.librarian.config.exception;

/**
 * Created by KunZhao on 15/12/12.
 */
public class CommonException extends RuntimeException {
    private Object args[];
    public CommonException(String msg) {
        super(msg);
        this.args = null;
    }
    public CommonException(String msg, Object... args) {
        this(msg, null, args);
    }

    public CommonException(String msg, Throwable throwable, Object... args) {
        super(msg, throwable);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}
