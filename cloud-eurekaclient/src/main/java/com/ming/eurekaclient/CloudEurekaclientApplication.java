package com.ming.eurekaclient;

import com.ming.eurekaclient.impl.package1.WriteSame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WriteSame.class)})
public class CloudEurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaclientApplication.class, args);
	}

}
