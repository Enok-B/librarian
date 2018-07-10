package com.enokb.librarian.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisShardInfo;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018/7/10 下午4:28
 **/
@Configuration
public class RedisConfig {

    @Bean(name = "jedisConnFactory")
    @Autowired
    public JedisConnectionFactory jedisConnectionFactory(@Value("${jedis.pool.host}") String host
            , @Value("${jedis.pool.port}") int port, @Value("${jedis.pool.password}") String password,
                                                         @Value("${jedis.pool.database}") int database) {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port);
//        jedisShardInfo.setPassword(password);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisShardInfo);
        jedisConnectionFactory.setDatabase(database);
        return jedisConnectionFactory;
    }

    @Bean(name = "redisTemplate")
    @Autowired
    public RedisTemplate<?, ?> redisTemplate(@Qualifier("jedisConnFactory") JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        return redisTemplate;
    }
}
