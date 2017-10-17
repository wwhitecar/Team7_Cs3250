package com.team7.app.services;

import com.team7.app.business.dto.ProfessorDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface ProfessorServices {

    /**
     * Creates a list of all professors that are currently in the
     * database.
     * @return list of all professors in the database
     */
    Iterable<ProfessorDto> listAllProfessor();

    /**
     * Finds a professors that resides in the database.
     * @param id - id number for the professors we are looking for.
     * @return the professors that we are looking for
     */
    ProfessorDto getProfessorById(Integer id);

    /**
     * Adds a professor to the database.
     * @param professor to be added.
     * @return the student that was added to the database.
     */
    ProfessorDto saveProfessor(ProfessorDto professor);

    /**
     * Delete a professor that is in the database.
     * @param id of the professor to be removed
     */
    void deleteProfessor(Integer id);
}
