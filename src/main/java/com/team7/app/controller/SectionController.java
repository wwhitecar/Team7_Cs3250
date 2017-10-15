package com.team7.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SectionController {

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param courseNumber - course specific number
     * @param professor - professor teaching the section
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createCourse(
            final @RequestParam("course_number") int courseNumber,
            final @RequestParam("professor") String professor) {

        Map<String, Object> params = new HashMap<>();
        params.put("course_number", courseNumber);
        params.put("professor", professor);

        return ("Success");
    }


    /**
     * Will quary the data base to pull the specific course
     * by the Course Number.
     * @param courseNumber - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/getcourse", method = RequestMethod.GET)
    public String readSectionByNumber(
            final @RequestParam("course_number") int courseNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("course_number", courseNumber);

        return "";
    }
}