package com.team7.app.services;

import com.team7.app.business.dto.WeekDto;
import com.team7.app.repositories.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class WeekServicesImpl implements WeekServices {


    /**
     *
     */
    @Autowired
    private WeekRepository weekRepository;

    /**
     *
     *
     */
    public void setWeekService(final WeekRepository weekRepo) { this.weekRepository = weekRepo;}

    /**
     *
     */
    @Override
    public Iterable<WeekDto> listAllWeeks() { return weekRepository.findAll(); }

    /**
     *
     */
    @Override
    public WeekDto getWeekByDbKey(final Integer Id) { return weekRepository.findOne(Id);}

    /**
     *
     */
    @Override
    public WeekDto saveWeek(final WeekDto week) { return weekRepository.save(week); }

    /**
     *
     */
    @Override
    public void deleteWeekByDbKey(final Integer id) { weekRepository.delete(id);}
}
