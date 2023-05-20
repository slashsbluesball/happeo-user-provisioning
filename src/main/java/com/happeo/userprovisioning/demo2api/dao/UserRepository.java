package com.happeo.userprovisioning.demo2api.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.happeo.userprovisioning.demo2api.model.provisioners.User;


public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
