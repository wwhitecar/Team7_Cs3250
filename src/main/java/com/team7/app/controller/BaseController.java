package com.team7.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BaseController {

  @Value("${test.description}")
  String description;

  @Value("${example.hello_msg}")
  String hello_msg;

  @Value("${example.hello_password}")
  String hello_pwd;

  @Autowired
  String testBean;
  
  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  public String hello(@RequestBody String user) {
 //do work
    return "Hello";
  }
  
}
