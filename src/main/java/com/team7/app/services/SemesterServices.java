package com.team7.app.services;

import com.team7.app.business.dto.SemesterDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface SemesterServices {

    /**
     * Creates a list of all semesters that are currently in the
     * database.
     * @return list of all semesters in the database
     */
    Iterable<SemesterDto> listAllSemesters();

    /**
     * Finds a semester that resides in the database.
     * @param id - id number for the semester we are looking for.
     * @return the semester that we are looking for
     */
    SemesterDto getSemesterById(Integer id);

    /**
     * Adds a semester to the database.
     * @param semester - to be added.
     * @return the semester that was added to the database.
     */
    SemesterDto saveSemester(SemesterDto semester);

    /**
     * Delete a semester that is in the database.
     * @param id - semester id to be removed
     */
    void deleteSemesterById(Integer id);
}
