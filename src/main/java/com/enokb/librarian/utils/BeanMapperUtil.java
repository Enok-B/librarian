package com.enokb.librarian.utils;

import com.enokb.librarian.config.exception.CommonException;
import org.springframework.beans.BeanUtils;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:16
 **/

public class BeanMapperUtil {
    public static <T> T createAndCopyProperties(Object source, Class<T> clazz) {
        try {
            T dest = clazz.newInstance();
            BeanUtils.copyProperties(source, dest);
            return dest;
        } catch (InstantiationException | IllegalAccessException e) {
            ExceptionUtil.propagate(CommonException.class, "the target object of the createAndCopyProperties" +
                    "must provided a default constructor", null);
        }
        return null;
    }
}
