package com.bootcamp.demo.bc_forum_ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum_ex3.service.UserService2;

@SpringBootApplication
public class BcForumEx3Application implements CommandLineRunner {

	@Autowired
	private UserService2 userService;

	public static void main(String[] args) {
		SpringApplication.run(BcForumEx3Application.class, args);
		System.out.println("...API Server Started...");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		userService.fetchAndStoreUsers();
	}

}
