package com.team7.app.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team7.app.business.UserRowMapper;
import com.team7.app.business.dto.UserDto;

/**
 * Class that will communicate with both the webapplication
 * and the data base to transfer information.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    /**
     * Wires from the configuration class 'BaseConfig'.
     */
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * Basically sql.insertUserSql = insertUser
     * controlled via yml file.
     */
    @Value("${sql.user.insertUserSql}")
    private String insertUserSql;

    /**
     * Basically sql.getUserSql = getUser
     * controlled via yml file.
     */
    @Value("${sql.user.getUserByIdSql}")
    private String getUserByIdSql;

    /**
     * Basically sql.deleteUserSql = deleteUser
     * controlled via yml file.
     */
    @Value("${sql.user.deleteUserByIdSql}")
    private String deleteUserByIdSql;

    /**
     *Basically sql.updateUserSql = updateUser
     * controlled via yml file.
     */
    @Value("${sql.user.updateUserByIdSql}")
    private String updateUserByIdSql;

    /**
     * Creates a student and puts it in the database.
     * @param id - id of the student
     * @param firstName - first name of the student
     * @param lastName - last name of student
     * @return String - message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(final @RequestParam("Id")int id,
                   final @RequestParam("First Name")String firstName,
                   final @RequestParam("Last Name")String lastName) {
        Map<String, Object> params = new HashMap<>();
        params.put("student_id", id);
        params.put("first_name", firstName);
        params.put("last_name", lastName);
        namedJdbcTemplate.update(insertUserSql, params);
        return "Success";
      }

    /**
     * Read a user from the database.
     * @param id - Value to search for user with
     * @return String with user infromation
     */
    @RequestMapping(value = "/student_id/", method = RequestMethod.GET)
      public String readUserById(final @RequestParam("Id") int id) {
          Map<String, Object> params = new HashMap<>();
          params.put("student_id", id);
          List<UserDto> dto = namedJdbcTemplate.query(getUserByIdSql,
                params, new UserRowMapper());
          UserDto user = dto.get(0);
          return ("Name: " + user.getFirstName() + " " + user.getLastName()
                  + "\nUser Id: " + user.getId());
      }

    /**
     * Update a user already in the database.
     * @param id - id of the user to be found
     * @param firstName - new first name of the user
     * @param lastName - new last name of the user
     * @return String to be displayed to user after trying to update
     */
      @RequestMapping(value = "/update", method = RequestMethod.GET)
      public String updateUserById(final @RequestParam("Id")int id,
             final @RequestParam("First Name")String firstName,
             final @RequestParam("Last Name")String lastName) {
        Map<String, Object> params = new HashMap<>();
        params.put("student_id", id);
        params.put("first_name", firstName);
        params.put("last_name", lastName);
        int rowsChanged = namedJdbcTemplate.update(updateUserByIdSql, params);
        if (rowsChanged < 1) {
            return ("Unable to find user to update,"
                    + " try again with different id.");
        }
        return "Successfully Updated";
      }

    /**
     * Delete a user that is in the database.
     * @param id - id of the user to be deleted
     * @return String to be displayed to user after deleteing them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteUserById(final @RequestParam("Id") int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("student_id", id);
        int rowsChanged = namedJdbcTemplate.update(deleteUserByIdSql, params);
        if (rowsChanged >= 1) {
            return "Successfully Removed";
        }
        return ("Unable to remove user, try again with different id");
      }
}
