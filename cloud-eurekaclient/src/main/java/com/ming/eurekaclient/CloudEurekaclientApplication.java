package com.ming.eurekaclient;

import com.ming.eurekaclient.impl.package1.WriteSame;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.ming.service,com.ming.eurekaclient"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WriteSame.class)})
@MapperScan("com.ming.dao")
public class CloudEurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaclientApplication.class, args);
	}

}
