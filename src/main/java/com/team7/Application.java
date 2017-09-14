package com.team7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//this application is references in the POM file to kick the application off

@Configuration
@ComponentScan //This scans for file that have @ configuration in them
@EnableAutoConfiguration //This also scans for files that have @ confirugation in them
@EnableSwagger2 //This enables swagger
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
