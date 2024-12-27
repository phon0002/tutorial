package com.tutorial.controller;

import com.tutorial.model.redis.UserRedis;
import com.tutorial.service.redis.UserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRedisController {

    private final UserRedisService userService;

    @Autowired
    public UserRedisController(UserRedisService userService) {
        this.userService = userService;
    }

    // Endpoint to save a user
    @PostMapping
    public void saveUser(@RequestBody UserRedis user) {
        userService.saveUser(user);
    }

    // Endpoint to get a user by ID
    @GetMapping("/{userId}")
    public UserRedis getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    // Additional endpoints or CRUD operations can be added based on your requirements

    // For example, an endpoint to update a user
    @PutMapping("/{userId}")
    public void updateUser(@PathVariable String userId, @RequestBody UserRedis updatedUser) {
        // Logic to update the user
    }

    // An endpoint to delete a user
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        // Logic to delete the user
    }
}

