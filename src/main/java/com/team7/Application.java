package com.team7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableSwagger2
public class Application {
  private static final Logger LOG = LoggerFactory.getLogger(Application.class.getName());
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean(name = "applicationVersion")
  public String applicationVersion() {
    String version = getClass().getPackage().getImplementationVersion();

    return version == null ? "unknown" : version;
  }
  
}
