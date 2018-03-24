package com.enokb.librarian.utils;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class ListUtil {

    public static <E,T> List<T> copyListProperties(List<E> source, List<T> target, Class<T> clazz) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }

        source.forEach(list -> {
            target.add(BeanMapperUtil.createAndCopyProperties(list, clazz));
        });
        return target;
    }
}
