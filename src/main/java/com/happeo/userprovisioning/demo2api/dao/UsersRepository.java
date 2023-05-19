package com.happeo.userprovisioning.demo2api.dao;

import com.happeo.userprovisioning.demo2api.model.users.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsersRepository extends MongoRepository<User, Integer> {
    
    @Query("{'organisationId': ?0}")
    Optional<List<User>> findByOrgId(String orgId);

    @Query("{'organisationId': ?0, 'isActive': ?1}")
    Optional<List<User>> findByOrgIdActive(String orgId, Boolean active);
}
