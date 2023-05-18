package com.happeo.userprovisioning.demo2api.dao;

import com.happeo.userprovisioning.demo2api.model.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, Integer> {
    
}
