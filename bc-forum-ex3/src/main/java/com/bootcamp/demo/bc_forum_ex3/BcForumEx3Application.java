package com.bootcamp.demo.bc_forum_ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum_ex3.service.UserService;

@SpringBootApplication
public class BcForumEx3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BcForumEx3Application.class, args);
	}

	@Autowired
	private UserService userService;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		userService.fetchAndStoreUsers();
	}

}
