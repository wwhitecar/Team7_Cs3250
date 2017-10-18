package com.team7.app.controller;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlles communication between the webpages in the application
 * and the database for the courses.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    protected CourseServices courseServices;

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

        CourseDto course = new CourseDto(department, courseNumber, credits,
                description, learningObjective, prereqs, coreqs);
        course = courseServices.saveCourse(course);
        if (course != null) {
            return (course.toString() + " Added Successfully <br/> <a href="
                    + "/" + ">Go Back to main screen</a>");
        }
        return ("Unable to create Course, <br/> <a href="
                + "/" + ">Go Back to main screen</a>");
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
        CourseDto course = courseServices.getCourseById(courseNumber);
        if (course == null) {
            return "Unable to find Course";
        }
        return (course.toString() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>");
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
        CourseDto course = new CourseDto(department, courseNumber, credits,
                description, learningObjective, prereqs, coreqs);
        course = courseServices.saveCourse(course);
        if (course != null) {
            return (course.toString() + " Updated Successfully <br/> <a href="
                    + "/" + ">Go Back to main screen</a>");
        }
        return ("Unable to find Course");
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
        courseServices.deleteCourse(courseNumber);
        if (readCourseByNumber(courseNumber).equals("Unable to find Course")) {
            return ("Removed Course"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return ("Unable to remove course, plz try again"
                + "<br/> <a href=" + "/" + ">Go Back to main screen</a>");
    }
}
