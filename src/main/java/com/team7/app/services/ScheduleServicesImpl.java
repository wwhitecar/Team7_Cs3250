package com.team7.app.services;

import com.team7.app.business.dto.ScheduleDto;
import com.team7.app.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class ScheduleServicesImpl implements ScheduleServices {

    /**
     * Schedule repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    @Autowired
    private ScheduleRepository scheduleRepository;

    /**
     * Setter for ScheduleRepository, used for testing purposes
     * only.
     * @param scheduleRepo - scheduleRepo to be used for testing
     */
    public void setScheduleRepository(final ScheduleRepository scheduleRepo) {
        this.scheduleRepository = scheduleRepo;
    }

    /**
     * Creates a list of all schedules that are currently in the
     * database.
     * @return list of all schedules in the database
     */
    @Override
    public Iterable<ScheduleDto> listAllSchedule() {
        return scheduleRepository.findAll();
    }

    /**
     * Finds a schedule that resides in the database.
     * @param id - id number for the schedule we are looking for.
     * @return the schedule that we are looking for
     */
    @Override
    public ScheduleDto getScheduleByName(final int id) {
        return scheduleRepository.findOne(id);
    }

    /**
     * Adds a schedule to the database.
     * @param schedule - to be added.
     * @return the schedule that was added to the database.
     */
    @Override
    public ScheduleDto saveSchedule(final ScheduleDto schedule) {
        return scheduleRepository.save(schedule);
    }

    /**
     * Delete a schedule that is in the database.
     * @param id - buildings id to be removed
     */
    @Override
    public void deleteScheduleByName(final int id) {
        scheduleRepository.delete(id);
    }
}
