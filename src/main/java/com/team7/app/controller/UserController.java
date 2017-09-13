package com.team7.app.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team7.app.business.UserRowMapper;
import com.team7.app.business.dto.UserDto;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired //Wires from the configuration class 'BaseConfig' 
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Value("${sql.insertUserSql}") //basically sql.insertUserSql = insertUser controlelled via yml file
	String insertUserSql;
	@Value("${sql.getUserByLastNameSql}")
	String getUserByLastNameSql;
	@RequestMapping(value = "/", method = RequestMethod.POST) //Creates a student and puts it in the database
	  public String createUser(@RequestBody UserDto user) {
		Map<String,Object> params = new HashMap<>();
		params.put("student_id", user.getId());
		params.put("first_name", user.getFirstName());
		params.put("last_name", user.getLastName());
		namedJdbcTemplate.update(insertUserSql, params);
	    return "Success";
	    
	  }
	  
	  @RequestMapping(value = "/lastName/{lastName}", method = RequestMethod.GET)
	  public List<UserDto> readUserByLastName(@PathVariable(value="lastName") String name) {
		  Map<String,Object> params = new HashMap<>();
		  params.put("last_name", name);
		  List<UserDto> dto = namedJdbcTemplate.query(getUserByLastNameSql, params, new UserRowMapper());
	    return dto;
	  }
	  
	  @RequestMapping(value = "/id/{id}", method = RequestMethod.GET) //create queries (reference yml file) 
	  public UserDto readUserById(@PathVariable(value="id") int id) {
		  UserDto dto = new UserDto();//Grab data from database and fill this
		 // dto.setName("bob");
		  dto.setId(1);
	    return dto;
	  }
	  
	  
	  @RequestMapping(value = "/update", method = RequestMethod.PUT) //Update first and last name by "student_id"  this will be similar to CREATE method
	  public String updateHello(@RequestBody UserDto user) {
	 
	    return "Success";
	  }
	
	  @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)//delete user by "student_id"  this will be similar to CREATE method
	  public String deleteUserById(@PathVariable(value="id") String id) {
	 
	    return "Success";
	  }

}
