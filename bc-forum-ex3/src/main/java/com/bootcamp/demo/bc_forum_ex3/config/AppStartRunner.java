package com.bootcamp.demo.bc_forum_ex3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum_ex3.service.UserService2;

@Component
@Configuration
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  private UserService2 userService;

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("...AppStartRunner Start...");
    userService.fetchAndStoreUsers();
    System.out.println("...AppStartRunner End...");
  }

}
