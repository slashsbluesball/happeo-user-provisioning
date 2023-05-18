package com.happeo.userprovisioning.demo2api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
// @SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Demo2ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2ApiApplication.class, args);
	}

}
