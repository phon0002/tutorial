package com.tutorial.repo;

import com.tutorial.model.mongo.full.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
    UserMongo findByUsername(String username);
}
