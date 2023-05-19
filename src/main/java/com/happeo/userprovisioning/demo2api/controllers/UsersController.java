package com.happeo.userprovisioning.demo2api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happeo.userprovisioning.demo2api.model.users.User;
import com.happeo.userprovisioning.demo2api.model.users.UserEntity;
import com.happeo.userprovisioning.demo2api.services.UsersService;

@RestController
@RequestMapping("/api/organisation/{orgId}")
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsersByOrg(@PathVariable String orgId, @RequestParam(required = false) Boolean active) {
        if (active == null)
            return ResponseEntity.ok(service.findAllUsersByOrgId(orgId));
        else 
            return ResponseEntity.ok(service.findAllUsersByOrgIdActive(orgId, active));
    }

    @PostMapping("/users/activate")
    @ResponseBody
    public ResponseEntity<List<User>> activateUsersByOrg(@PathVariable String orgId) {
        List<User> resp = service.activateAllUsersByOrg(orgId);
        if (resp.isEmpty())
            return new ResponseEntity<List<User>>(resp, HttpStatus.NO_CONTENT);
        else
            return ResponseEntity.ok(resp);
    }

    @PostMapping(path = "/provisioner/{provId}/users",
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserEntity> addUser(@PathVariable String orgId, @PathVariable String provId, @RequestBody UserEntity userRequest) {
        User userData = User.builder()
            .email(userRequest.getEmail())
            .firstName(userRequest.getName().getFirstName())
            .lastName(userRequest.getName().getLastName())
            .organisationId(orgId)
            .externalId(userRequest.getId())
            .isActive(false).build();

        service.addUser(userData);

        userRequest.setApplicationId(userData.getId());
        return new ResponseEntity<UserEntity>(userRequest, HttpStatus.CREATED);
    }
}
