package com.ming.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CloudApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApigatewayApplication.class, args);
	}

}
