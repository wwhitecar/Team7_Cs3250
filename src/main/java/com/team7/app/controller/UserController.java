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
	
	@Value("${sql.insertUserSql}")
	//basically sql.insertUserSql = insertUser controlelled via yml file.
	// Look at yml file to see how these variables are added (Under resources folder)
	String insertUserSql;
	@Value("${sql.getUserByIdSql}")
	String getUserByIdSql;
	@Value("${sql.deleteUserByIdSql}")
	String deleteUserByIdSql;
	@Value("${sql.updateUserByIdSql}")
	String updateUserByIdSql;

	/**
	 * Creates a student and puts it in the database
	 * @param id - id of the student
	 * @param firstName - first name of the student
	 * @param lastName - last name of student
	 * @return String - message to be displayed after entry
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public String createUser(@RequestParam("Id")int id, @RequestParam("First Name")String firstName,
							   @RequestParam("Last Name")String lastName) {
		Map<String,Object> params = new HashMap<>();
		params.put("student_id", id);
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		namedJdbcTemplate.update(insertUserSql, params);
	    return "Success";
	    
	  }

	/**
	 * Read a user from the database
	 * @param id - Value to search for user with
	 * @return String with user infromation
	 */
	@RequestMapping(value = "/student_id/", method = RequestMethod.GET)
	  public String readUserById(@RequestParam("Id") int id) {
		  Map<String,Object> params = new HashMap<>();
		  params.put("student_id", id);
		  List<UserDto> dto = namedJdbcTemplate.query(getUserByIdSql, params, new UserRowMapper());
		  UserDto user = dto.get(0);
		  return ("Name: " + user.getFirstName() +" " + user.getLastName()
				  + "\nUser Id: " + user.getId());
	  }

	/**
	 * Update a user already in the database
	 * @param id - id of the user to be found
	 * @param firstName - new first name of the user
	 * @param lastName - new last name of the user
	 * @return String to be displayed to user after trying to update
	 */
	  @RequestMapping(value = "/update", method = RequestMethod.GET) //Update first and last name by "student_id"  this will be similar to CREATE method
	  public String updateUserById(@RequestParam("Id")int id, @RequestParam("First Name")String firstName,
			   @RequestParam("Last Name")String lastName) {
		  Map<String,Object> params = new HashMap<>();
		  params.put("student_id", id);
		  params.put("first_name", firstName);
		  params.put("last_name", lastName);
		  namedJdbcTemplate.update(updateUserByIdSql, params);
	 
	    return "Success";
	  }

	/**
	 * Delete a user that is in the database
	 * @param id - id of the user to be deleted
	 * @return String to be displayed to user after deleteing them
	 */
	@RequestMapping(value = "/id/", method = RequestMethod.GET)//delete user by "student_id"  this will be similar to CREATE method
	  public String deleteUserById(@RequestParam("Id") int id) {
		  Map<String,Object> params = new HashMap<>();
		  params.put("student_id", id);
		  namedJdbcTemplate.update(deleteUserByIdSql, params);
	 
	    return "Success";
	  }

}
