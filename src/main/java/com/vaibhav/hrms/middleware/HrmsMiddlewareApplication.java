package com.vaibhav.hrms.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class HrmsMiddlewareApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrmsMiddlewareApplication.class, args);
	}

}
