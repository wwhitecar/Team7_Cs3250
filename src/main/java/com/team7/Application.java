package com.team7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This application is references in the POM file
 * to kick the application off.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableSwagger2 //This enables swagger
public class Application {

  /**
   * Main method for the application.
   * @param args - list of arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
