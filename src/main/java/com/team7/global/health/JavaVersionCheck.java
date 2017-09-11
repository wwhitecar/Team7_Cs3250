package com.team7.global.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class JavaVersionCheck implements HealthIndicator {

  @Override
  public Health health() {
    Health retVal = Health.down().build();
    try {
      String version = System.getProperty("java.version");
      retVal = Health.status(version).build();
    } catch (Throwable t) {
    }
    return retVal;
  }
}