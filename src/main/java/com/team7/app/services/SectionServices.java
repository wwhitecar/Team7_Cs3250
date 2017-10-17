package com.team7.app.services;

import com.team7.app.business.dto.SectionDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface SectionServices {

    /**
     * Creates a list of all sections that are currently in the
     * database.
     * @return list of all sections in the database
     */
    Iterable<SectionDto> listAllSection();

    /**
     * Finds a section that resides in the database.
     * @param id - id number for the section we are looking for.
     * @return the section that we are looking for
     */
    SectionDto getSectionById(Integer id);

    /**
     * Adds a section to the database.
     * @param section to be added.
     * @return the section that was added to the database.
     */
    SectionDto saveSection(SectionDto section);

    /**
     * Delete a section that is in the database.
     * @param id of the section to be removed
     */
    void deleteSection(Integer id);
}
