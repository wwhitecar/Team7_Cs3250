package com.team7.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {
  @Bean
  public String testBean() {
    return "Hello";
  }
}
