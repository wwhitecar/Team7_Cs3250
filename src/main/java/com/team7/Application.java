package com.team7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This application is references in the POM file
 * to kick the application off.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

  /**
   * Main method for the application.
   * @param args - list of arguments
   */
  public static void main(final String[] args) {
      SpringApplication.run(Application.class, args);
  }
}
