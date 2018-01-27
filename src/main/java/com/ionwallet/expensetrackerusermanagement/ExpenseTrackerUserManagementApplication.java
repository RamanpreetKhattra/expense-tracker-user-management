package com.ionwallet.expensetrackerusermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.ionwallet"})
@EntityScan(basePackages={"com.ionwallet.domain"})
public class ExpenseTrackerUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerUserManagementApplication.class, args);
	}
}
