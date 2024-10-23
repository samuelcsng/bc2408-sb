package com.bootcamp.demo.bc_yahoo_finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BcYahooFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcYahooFinanceApplication.class, args);
		System.out.println("API Server start...");
	}

}
