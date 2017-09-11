package com.team7.app.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team7.app.business.dto.UserDto;

@RestController("/user")
public class UserController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public String createUser(@RequestBody UserDto user) {
	 //do work
	    return "Success";
	    
	  }
	  
	  @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	  public UserDto readUserByName(@PathVariable(value="name") String name) {
		  UserDto dto = new UserDto();//Grab data from database and fill this
		  dto.setName("bob");
		  dto.setId(1);
	    return dto;
	  }
	  
	  @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	  public UserDto readUserById(@PathVariable(value="id") String id) {
		  UserDto dto = new UserDto();//Grab data from database and fill this
		  dto.setName("bob");
		  dto.setId(1);
	    return dto;
	  }
	  
	  
	  @RequestMapping(value = "/update", method = RequestMethod.PUT)
	  public String updateHello(@RequestBody UserDto user) {
	 
	    return "Success";
	  }
	  
	  @RequestMapping(value = "/name/{name}", method = RequestMethod.DELETE)
	  public String deleteUserByName(@PathVariable(value="name") String name) {
	 
	    return "Success";
	  }
	  
	  @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	  public String deleteUserById(@PathVariable(value="id") String id) {
	 
	    return "Success";
	  }

}
