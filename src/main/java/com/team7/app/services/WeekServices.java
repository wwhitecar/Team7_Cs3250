package com.team7.app.services;

import com.team7.app.business.dto.WeekDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface WeekServices {

    /**
     * Creates a list of all weeks that are currently in the
     * database.
     * @return list of all weeks in the database
     */
    Iterable<WeekDto> listAllWeeks();

    /**
     * Finds a week that resides in the database.
     * @param id - id number for the semester we are looking for.
     * @return the week that we are looking for
     */
    WeekDto getWeekByDbKey(Integer id);

    /**
     * Adds a week to the database.
     * @param week  - to be added.
     * @return the week that was added to the database.
     */
    WeekDto saveWeek(WeekDto week);

    /**
     * Delete a week that is in the database.
     * @param id - week id to be removed
     */
    void deleteWeekByNumber(Integer id);
}
