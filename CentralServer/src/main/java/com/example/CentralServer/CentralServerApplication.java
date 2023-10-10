package com.example.CentralServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CentralServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralServerApplication.class, args);
	}

}
