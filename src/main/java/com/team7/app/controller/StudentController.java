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

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    private StudentServices studentServices;

    /**
     * Bean to be used throughout the professor class.
     * @param studService - bean to be created
     */
    @Autowired
    public void setProductService(final StudentServices studService) {
        this.studentServices = studService;
    }

    /**
     * Creates a student and puts it in the database.
     * @param id - id of the student.
     * @param firstName - first name of the student.
     * @param lastName - last name of the student.
     * @return message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createStudent(final @RequestParam("Id")int id,
                             final @RequestParam("First Name")String firstName,
                             final @RequestParam("Last Name")String lastName) {
        StudentDto student = new StudentDto(firstName, lastName, id);
        studentServices.saveStudent(student);
        if (!readStudentById(id).equals("Unable to find Student")) {
            return (student.toString()  + " Added Successfully <br/> <a href="
                    + "/" + ">Go Back to main screen</a>");
        }
        return ("Error adding Student for some reason");
      }

    /**
     * Read a professor and puts it in the database.
     * @param id - id of the student.
     * @return message to be displayed after finding the student
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
     * @param id - id of the student.
     * @param firstName - first name of the student
     * @param lastName - the last name of hte student.
     * @return String to be displayed to user after trying to update
     */
      @RequestMapping(value = "/update", method = RequestMethod.GET)
      public String updateStudentById(final @RequestParam("Id")int id,
                              final @RequestParam("First Name")String firstName,
                              final @RequestParam("Last Name")String lastName) {
          StudentDto student = new StudentDto(firstName, lastName, id);
          studentServices.saveStudent(student);
          return ("Successfully updated: <br/>"
                  + readStudentById(student.getId()));
      }

    /**
     * Delete a user that is in the database.
     * @param id - id to find and remove the student from database
     * @return String to be displayed after deleting the user
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteStudentById(final @RequestParam("Id") Integer id) {
        studentServices.deleteStudent(id);
        String string = "/";
        if (readStudentById(id).equals("Unable to find Student")) {
            return ("Removed Student"
                    + "<br/> <a href=" + string
                    + ">Go Back to main screen</a>");
        }
        return "Unable to find student, plz try again";
      }
}
