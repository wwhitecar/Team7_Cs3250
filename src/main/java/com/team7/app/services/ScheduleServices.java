package com.team7.app.services;

import com.team7.app.business.dto.ScheduleDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface ScheduleServices {

    /**
     * Creates a list of all schedules that are currently in the
     * database.
     * @return list of all schedule in the database
     */
    Iterable<ScheduleDto> listAllSchedule();

    /**
     * Finds a building that resides in the database.
     * @param id - id number for the schedule we are looking for.
     * @return the schedule that we are looking for
     */
    ScheduleDto getScheduleByName(int id);

    /**
     * Adds a schedule to the database.
     * @param schedule - to be added.
     * @return the building that was added to the database.
     */
    ScheduleDto saveSchedule(ScheduleDto schedule);

    /**
     * Delete a schedule that is in the database.
     * @param id - schedule id to be removed
     */
    void deleteScheduleByName(int id);
}
