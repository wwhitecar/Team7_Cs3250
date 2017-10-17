package com.team7.app.services;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class CourseServicesImpl implements CourseServices {

    /**
     * Course repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    private CourseRepository courseRepository;


    /**
     * Autowired so spring can make  a bean and use it.
     * @param cRepository - repo to be used by spring
     */
    @Autowired
    public void setCourseRepository(final CourseRepository cRepository) {
        this.courseRepository = cRepository;
    }

    /**
     * Creates a list of all courses that are currently in the
     * database.
     * @return list of all courses in the database
     */
    @Override
    public Iterable<CourseDto> listAllCourse() {
        return courseRepository.findAll();
    }

    /**
     * Finds a course that resides in the database.
     * @param id - id number for the course we are looking for.
     * @return the course that we are looking for
     */
    @Override
    public CourseDto getCourseById(final Integer id) {
        return courseRepository.findOne(id);
    }

    /**
     * Adds a course to the database.
     * @param course to be added.
     * @return the course that was added to the database.
     */
    @Override
    public CourseDto saveCourse(final CourseDto course) {
        return courseRepository.save(course);
    }

    /**
     * Delete a course that is in the database.
     * @param id of the course to be removed
     */
    @Override
    public void deleteCourse(final Integer id) {
        courseRepository.delete(id);
    }
}
