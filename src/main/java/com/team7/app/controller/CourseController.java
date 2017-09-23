package com.team7.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Controlles communication between the webpages in the application
 * and the database for the courses.
 */
public class CourseController {

    /**
     * Wires from the configuration class 'BaseConfig'.
     */
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * Basically sql.insertUserSql = insertUser
     * controlled via yml file.
     */
    @Value("${sql.insertCourseSql}")
    private String insertCourseSql;

    /**
     * Basically sql.getCourseSql = getCourse
     * controlled via yml file.
     */
    @Value("${sql.getCourseByNumber}")
    private String getCourseByNumber;

    /**
     * Basically sql.deleteUserSql = deleteUser
     * controlled via yml file.
     */
    @Value("${sql.deleteCourseByNumber}")
    private String deleteCourseByNumber;

    /**
     *Basically sql.updateUserSql = updateUser
     * controlled via yml file.
     */
    @Value("${sql.updateCourseByIdSql}")
    private String updateCourseByIdSql;
}
