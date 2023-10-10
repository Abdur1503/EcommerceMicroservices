package com.example.UserService2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserService2Application {

	public static void main(String[] args) {
		SpringApplication.run(UserService2Application.class, args);
	}

}
