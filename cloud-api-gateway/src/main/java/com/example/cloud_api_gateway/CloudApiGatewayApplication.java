package com.example.cloud_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class CloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiGatewayApplication.class, args);
	}

}
