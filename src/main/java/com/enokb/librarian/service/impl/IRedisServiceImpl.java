package com.enokb.librarian.service.impl;

import com.enokb.librarian.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018/7/10 下午4:34
 **/
@Service
public class IRedisServiceImpl implements IRedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String opsForList() {
        long i = redisTemplate.opsForList().leftPush("test", "data");
        System.err.println(i);
        return null;
    }
}
