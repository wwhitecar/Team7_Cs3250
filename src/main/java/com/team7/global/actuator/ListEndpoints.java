package com.team7.global.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListEndpoints extends AbstractEndpoint<List<Endpoint>> {

  private List<Endpoint> endpoints;

  @Autowired
  public ListEndpoints(List<Endpoint> endpoints) {
    super("listEndpoints");
    this.endpoints = endpoints;
  }

  public List<Endpoint> invoke() {
    return this.endpoints;
  }
}
