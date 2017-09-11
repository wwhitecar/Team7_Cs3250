package com.team7.global.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AppVersionCheck implements HealthIndicator {

  @Override
  public Health health() {
    try {
      return Health.status(this.getClass().getPackage().getImplementationVersion()).build();
    } catch (Throwable t) {
      return Health.status("UNKNOWN").build();
    }
  }
}
