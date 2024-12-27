package com.tutorial.model.redis;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("User")
public class UserRedis {
    private String id;
}
