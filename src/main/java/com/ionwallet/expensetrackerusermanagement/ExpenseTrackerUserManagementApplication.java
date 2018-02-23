package com.ionwallet.expensetrackerusermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.ionwallet"})
@EnableEurekaClient
public class ExpenseTrackerUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerUserManagementApplication.class, args);
	}
}
