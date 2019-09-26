package com.ming.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudEurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaclientApplication.class, args);
	}

}
