package com.bootcamp.demo.bc_forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BcForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcForumApplication.class, args);
		System.out.println("...API Server Started...");
	}

}
