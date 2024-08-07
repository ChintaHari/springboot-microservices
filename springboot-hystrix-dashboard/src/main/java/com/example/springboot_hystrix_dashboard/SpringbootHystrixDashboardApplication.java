package com.example.springboot_hystrix_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringbootHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHystrixDashboardApplication.class, args);
	}

}
