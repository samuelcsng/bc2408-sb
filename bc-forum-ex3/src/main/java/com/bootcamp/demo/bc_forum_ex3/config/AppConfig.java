package com.bootcamp.demo.bc_forum_ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean(name = "JPHRestTemplate")
  RestTemplate RestTemplateForJPH() {
    return new RestTemplate();
  }

}