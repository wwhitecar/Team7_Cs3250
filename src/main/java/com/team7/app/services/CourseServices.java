package com.team7.app.services;

import com.team7.app.business.dto.CourseDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface CourseServices {

    /**
     * Creates a list of all courses that are currently in the
     * database.
     * @return list of all courses in the database
     */
    Iterable<CourseDto> listAllCourse();

    /**
     * Finds a course that resides in the database.
     * @param id - id number for the course we are looking for.
     * @return the course that we are looking for
     */
    CourseDto getCourseById(Integer id);

    /**
     * Adds a course to the database.
     * @param course to be added.
     * @return the course that was added to the database.
     */
    CourseDto saveCourse(CourseDto course);

    /**
     * Delete a course that is in the database.
     * @param id of the course to be removed
     */
    void deleteCourse(Integer id);
}
