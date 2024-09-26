package com.hotelReviewSystem.userService.userService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  //this will be when we are using feign  client for internal calling
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}



//we are making this as service as client in okta in yml config also because it is calling internally other two service
//so it is also acting as a client to other services thats why we are making this service as a client service for
//spring security  oauth2