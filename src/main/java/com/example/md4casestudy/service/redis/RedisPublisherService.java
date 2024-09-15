package com.example.md4casestudy.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;

@Service
public class RedisPublisherService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String CHANNEL = "user-channel";

    public void publishMessage(String message) {
        redisTemplate.convertAndSend(CHANNEL, message);
    }
}
