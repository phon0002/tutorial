package com.tutorial.repo;

import com.tutorial.model.redis.UserRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedisRepository extends CrudRepository<UserRedis, String> {
    // You can add custom queries here if needed
}


