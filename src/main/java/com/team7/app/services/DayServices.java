package com.team7.app.services;

import com.team7.app.business.dto.DayDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface DayServices {

    /**
     * Creates a list of all days that are currently in the
     * database.
     * @return list of all days in the database
     */
    Iterable<DayDto> listAllDays();

    /**
     * Finds a day that resides in the database.
     * @param id - id number for the day we are looking for.
     * @return the day that we are looking for
     */
    DayDto getDayByName(int id);

    /**
     * Adds a day to the database.
     * @param day - to be added.
     * @return the day that was added to the database.
     */
    DayDto saveDay(DayDto day);

    /**
     * Delete a day that is in the database.
     * @param id - days id to be removed
     */
    void deleteDayByName(int id);
}
