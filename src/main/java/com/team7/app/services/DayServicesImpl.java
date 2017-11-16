package com.team7.app.services;

import com.team7.app.business.dto.DayDto;
import com.team7.app.repositories.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class DayServicesImpl implements DayServices {

    /**
     * day repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    @Autowired
    private DayRepository dayRepository;

    /**
     * Setter for Day Repository, used for testing purposes
     * only.
     * @param dayRepo - dayRepo to be used for testing
     */
    public void setDayRepository(final DayRepository dayRepo) {
        this.dayRepository = dayRepo;
    }

    /**
     * Creates a list of all days that are currently in the
     * database.
     * @return list of all days in the database
     */
    @Override
    public Iterable<DayDto> listAllDays() {
        return dayRepository.findAll();
    }

    /**
     * Finds a day that resides in the database.
     * @param id - id number for the day we are looking for.
     * @return the day that we are looking for
     */
    @Override
    public DayDto getDayByName(final int id) {
        return dayRepository.findOne(id);
    }

    /**
     * Adds a day to the database.
     * @param day - to be added.
     * @return the day that was added to the database.
     */
    @Override
    public DayDto saveDay(final DayDto day) {
        return dayRepository.save(day);
    }

    /**
     * Delete a day that is in the database.
     * @param id - days id to be removed
     */
    @Override
    public void deleteDayByName(final int id) {
        dayRepository.delete(id);
    }
}
