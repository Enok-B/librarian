package com.enokb.utils;

import java.util.UUID;

public class IDUtil {

    public static String newId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
