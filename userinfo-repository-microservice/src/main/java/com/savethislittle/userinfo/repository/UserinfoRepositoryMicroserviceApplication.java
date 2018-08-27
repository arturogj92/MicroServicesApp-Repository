package com.savethislittle.userinfo.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserinfoRepositoryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserinfoRepositoryMicroserviceApplication.class, args);
	}
}
