package com.happeo.userprovisioning.demo2api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happeo.userprovisioning.demo2api.dao.UsersRepository;
import com.happeo.userprovisioning.demo2api.model.users.User;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }
    
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public List<User> findAllUsersByOrgId(String orgId) {
        return repository.findByOrgId(orgId).orElseThrow(() -> new RuntimeException(
            String.format("Cannot find any users with organization ID %s", orgId)));
    }

    public List<User> findAllUsersByOrgIdActive(String orgId, Boolean active) {
        return repository.findByOrgIdActive(orgId, active).orElseThrow(() -> new RuntimeException(
            String.format("Cannot find any users with organization ID %s", orgId)));
    }

    public List<User> activateAllUsersByOrg(String orgId) {
        List<User> inactiveUsers = repository.findByOrgIdActive(orgId, false).get();
        if (inactiveUsers == null)
            return List.of();
        else
            for (User u : inactiveUsers) {
                u.setIsActive(true);
                repository.save(u);
            }

        return inactiveUsers;
    }

    public void addUser(User userData) {
        // repository.save(userData);
        repository.insert(userData);
    }
}
