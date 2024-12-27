package com.tutorial.service.redis;

import com.tutorial.model.redis.UserRedis;
import com.tutorial.repo.UserRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserRedisService {

    @Autowired
    private UserRedisRepository userRepository;

    public void saveUser(UserRedis user) {
        userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#userId")
    public UserRedis getUser(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @CachePut(value="users")
    // With the @CachePut annotation, we can update the content of the cache
    // without interfering with the method execution.
    // That is, the method will always be executed and the result cached
    public UserRedis getUser2(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @CacheEvict(value = "users", key = "#userId")
    public void evictUserCache(String userId) {
        // This method will remove the user with the specified userId from the cache
    }

    @CacheEvict(value = "users", allEntries = true)
    @Scheduled(fixedRateString = "3600")
    // Eviction on-Schedule (Automatic)
    public void emptyUsersCache() {
        //logger.info("emptying Hotels cache");
    }

    public void updateUser(UserRedis updatedUser) {
        userRepository.save(updatedUser);
        // Eviction on-Demand
        evictUserCache(updatedUser.getId());
    }
    // You can add more business logic here
}

