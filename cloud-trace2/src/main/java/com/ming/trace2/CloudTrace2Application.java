package com.ming.trace2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudTrace2Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudTrace2Application.class, args);
	}

}
