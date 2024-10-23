package com.bootcamp.demo.final_project_1_yf.config;
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

