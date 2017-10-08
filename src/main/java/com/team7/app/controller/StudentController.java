package com.team7.app.controller;

import com.team7.app.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import com.team7.app.business.dto.StudentDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class that will communicate with both the webapplication
 * and the data base to transfer information.
 */

@RestController
@RequestMapping(value = "/user")
public class StudentController {

    private StudentServices studentServices;

    @Autowired
    public void setProductService(final StudentServices studService) {
        this.studentServices = studService;
    }

    /**
     * Creates a student and puts it in the database.
     * @return String - message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public StudentDto createStudent(final @RequestParam("Id")int id,
                             final @RequestParam("First Name")String firstName,
                             final @RequestParam("Last Name")String lastName) {
        StudentDto student = new StudentDto(firstName, lastName, id);
        return studentServices.saveStudent(student);
      }

    /**
     * Read a user from the database.
     * @return String with user information
     */
    @RequestMapping(value = "/student_id")
      public String readStudentById(final @RequestParam("Id") Integer id) {
          StudentDto student = studentServices.getStudentById(id);
          if (student == null) {
              return "Unable to find Student";
          }
          String string = "/";
          return student.toString()  + "<br/> <a href="
                  + string + ">Go Back to main screen</a>";
      }

    /**
     * Update a user already in the database.
     * @return String to be displayed to user after trying to update
     */
      @RequestMapping(value = "/update", method = RequestMethod.GET)
      public String updateStudentById(final @RequestParam("Id")int id,
                              final @RequestParam("First Name")String firstName,
                              final @RequestParam("Last Name")String lastName) {
          StudentDto student = new StudentDto(firstName, lastName, id);
          studentServices.saveStudent(student);
          return ("Successfully updated: <br/>" + readStudentById(student.getId()));
      }

    /**
     * Delete a user that is in the database.
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteStudentById(final @RequestParam("Id") Integer id) {
        studentServices.deleteStudent(id);
        String string = "/";
        return ("I dunno how to check....but its not in the database if it was "
                + "<br/> <a href=" + string + ">Go Back to main screen</a>");
      }
}
