package com.bootcamp.demo.bc_forum_ex3;

import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BcForumEx3Application {

	public static void main(String[] args) {
		SpringApplication.run(BcForumEx3Application.class, args);
		System.out.println(LocalDateTime.now() + "...API Server Started...\n");
	}

}
