package com.enokb.librarian.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:17
 **/

public class ExceptionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);

    public final static <T extends RuntimeException> void propagate(Class<T> clazz, String msg, Throwable t, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, Throwable.class, Object[].class);
            T instance = constructor.newInstance(msg, t, args);
            throw instance;
        } catch (NoSuchMethodException e) {
            logger.warn("get constructor of the exception failed, use default constructor ", e);
        } catch (InvocationTargetException e) {
            logger.warn("the exception occurs when invoke exception constructor, use default exception  ", e);
        } catch (InstantiationException e) {
            logger.warn("the failed occurs when instantiate exception, use default exception  ", e);
        } catch (IllegalAccessException e) {
            logger.warn("the illegal privilege when access exception constructor, use default exception  ", e);
        }

        throw new RuntimeException(t);
    }
}
