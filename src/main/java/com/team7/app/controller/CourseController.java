package com.team7.app.controller;


import com.team7.app.business.CourseRowMapper;
import com.team7.app.business.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlles communication between the webpages in the application
 * and the database for the courses.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    /**
     * Wires from the configuration class 'BaseConfig'.
     */
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * Basically sql.insertCourseSql = insertCourse
     * controlled via yml file.
     */
    @Value("${sql.course.insertCourseSql}")
    private String insertCourseSql;
    
    @Value("${sql.course.getAllCoursesSql}")
    private String getAllCoursesSql;

    /**
     * Basically sql.getCourseSql = getCourse
     * controlled via yml file.
     */
    @Value("${sql.course.getCourseByNumber}")
    private String getCourseByNumber;

    /**
     * Basically sql.deleteCourseByNumber = deleteCoures
     * controlled via yml file.
     */
    @Value("${sql.course.deleteCourseByNumber}")
    private String deleteCourseByNumber;

    /**
     *Basically sql.updateCourseByNumber = updateCourse
     * controlled via yml file.
     */
    @Value("${sql.course.updateCourseByNumber}")
    private String updateCourseByNumber;

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param department - department the course belongs to
     * @param courseNumber - course specific number
     * @param credits - number of credits the course is worth
     * @param description - description of the course
     * @param learningObjective - what is to be learned by the course
     * @param prereqs - required student level for the course
     * @param coreqs - required courses to take the class
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createCourse(
            final @RequestParam("department") String department,
            final @RequestParam("course_number") int courseNumber,
            final @RequestParam("credits") int credits,
            final @RequestParam("description") String description,
            final @RequestParam("learning_objective") String learningObjective,
            final @RequestParam("prereqs") int prereqs,
            final @RequestParam("coreqs") int coreqs) {

        Map<String, Object> params = new HashMap<>();
        params.put("department", department);
        params.put("course_number", courseNumber);
        params.put("credits", credits);
        params.put("description", description);
        params.put("learning_objective", learningObjective);

        List<CourseDto> courseList = namedJdbcTemplate.query(getAllCoursesSql, new CourseRowMapper());
        boolean foundPreReq = false;
        boolean foundCoReq = false;
        for (CourseDto course : courseList) {
            if (course.getCourseNumber() == prereqs) {
                params.put("prereqs", course.getCourseNumber());
                foundPreReq = true;
            }
            if (course.getCourseNumber() == coreqs) {
                params.put("coreqs", course.getCourseNumber());
                foundCoReq = true;
            }
        }
        if (!foundPreReq) {
            params.put("prereqs", 0000);
        }
        if (!foundCoReq) {
            params.put("coreqs", 0000);
        }

        int rowsChanged = namedJdbcTemplate.update(insertCourseSql, params);
        return ("Success");
    }

    /**
     * Will quary the data base to pull the specific course
     * by the Course Number.
     * @param courseNumber - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/getcourse", method = RequestMethod.GET)
    public String readCourseByNumber(
            final @RequestParam("course_number") int courseNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("course_number", courseNumber);
        List<CourseDto> dto = namedJdbcTemplate.query(getCourseByNumber,
                params, new CourseRowMapper());
        if (dto.size() == 0){
            return ("Course not found, please try again with another Course Number");
        }
        CourseDto course = dto.get(0);
        return course.toString();
    }

    /**
     * Will quarry the data base for a specific course provided by the
     * course number and will updated it.
     * @param department - department the corse belongs to
     * @param courseNumber - the idetifying course number
     * @param credits - number of credits the course is worth
     * @param description - description of the course
     * @param learningObjective - things we are trying to learn with this course
     * @param prereqs - required standing for a course
     * @param coreqs - the coreqs for a coures
     * @return result of trying to update a course
     */
    @RequestMapping(value = "/updatecourse", method = RequestMethod.GET)
    public String updateCourseByNumber(
            final @RequestParam("department") String department,
            final @RequestParam("course_number") int courseNumber,
            final @RequestParam("credits") int credits,
            final @RequestParam("description") String description,
            final @RequestParam("learning_objective") String learningObjective,
            final @RequestParam("prereqs") int prereqs,
            final @RequestParam("coreqs") int coreqs) {
        Map<String, Object> params = new HashMap<>();
        params.put("department", department);
        params.put("course_number", courseNumber);
        params.put("credits", credits);
        params.put("description", description);
        params.put("learning_objective", learningObjective);

        List<CourseDto> courseList = namedJdbcTemplate.query(getCourseByNumber, params,  new CourseRowMapper());

        boolean foundPreReq = false;
        boolean foundCoReq = false;
        for (CourseDto course : courseList)  {
            if (course.getCourseNumber() == prereqs){
                params.put("prereqs", course.getCourseNumber());
                foundPreReq = true;
            }
            if (course.getCourseNumber() == course.getCourseNumber()) {
                params.put("coreqs", course.getCourseNumber());
                foundCoReq = true;
            }
        }
        if (!foundPreReq){
            params.put("prereqs", 0000);
        }
        if (!foundCoReq){
            params.put("coreqs", 0000);
        }

        int rowsChanged = namedJdbcTemplate.update(updateCourseByNumber, params);
        if (rowsChanged == 0){
            return ("Failed to find the course you are trying to update, please try again.");
        }
        return "Successfully Updated";
    }

    /**
     * Will attempt to remove a course from the database that corresponds
     * to course number provided to the webpage.
     * @param courseNumber - number of the course we would like to delete
     * @return status of the delete request
     */
    @RequestMapping (value = "/deletecourse", method = RequestMethod.GET)
    public String deleteCourseByNumber(
            final @RequestParam("course_number") int courseNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("course_number", courseNumber);
        int rowsChanged =
                namedJdbcTemplate.update(deleteCourseByNumber, params);
        if (rowsChanged == 0) {
            return ("Unable to find course to remove, please try again");
        }
        return "Successfully Removed";
    }
}
