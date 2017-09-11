package com.team7.global.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppVersionCheck implements HealthIndicator {

  @Override
  public Health health() {
    try {
      return Health.status(this.getClass().getPackage().getImplementationVersion()).build();
    } catch (Throwable t) {
      log.error(t.getMessage());
      return Health.status("UNKNOWN").build();
    }
  }
}
