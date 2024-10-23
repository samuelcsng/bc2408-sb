package com.bootcamp.demo.bc_yahoo_finance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean(name = "YFRestTemplate")
  RestTemplate RestTemplateForYF() {
    return new RestTemplate();
  }

}

