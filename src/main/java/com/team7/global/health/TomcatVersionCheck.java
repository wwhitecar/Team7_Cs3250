package com.team7.global.health;

import org.apache.catalina.util.ServerInfo;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TomcatVersionCheck implements HealthIndicator {

  @Override
  public Health health() {
    Health retVal = Health.down().build();
    try {
      String version = ServerInfo.getServerInfo();
      retVal = Health.status(version).build();
    } catch (Throwable t) {
    }
    return retVal;
  }
}