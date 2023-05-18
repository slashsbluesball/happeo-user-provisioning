package com.happeo.userprovisioning.demo2api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/msg")
public class TestController {
    
    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello Happeo! :-)");
    }
}
