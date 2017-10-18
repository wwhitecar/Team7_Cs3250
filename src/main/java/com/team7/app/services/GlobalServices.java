package com.team7.app.services;

import com.team7.app.business.dto.GlobalDto;


/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */

public interface GlobalServices {

    /**
     * Creates a list of all globals that are currently in the
     * database.
     * @return list of all courses in the database
     */
    Iterable<GlobalDto> listAllGlobals();

    /**
     * Finds a global that resides in the database.
     * @param name - name of the university we are looking for
     * @return the course that we are looking for
     */
    GlobalDto getGlobalByName(String name);

    /**
     * Adds a global to the database.
     * @param global to be added.
     * @return the global that was added to the database.
     */
    GlobalDto saveGlobal(GlobalDto global);

    /**
     * Delete a course that is in the database.
     * @param name of the course to be removed
     */
    void deleteGlobal(String name);
}
