package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WeekDto {

    @Id
    int weekNumber;

    private DayDto mon, tues, wed, thurs, fri, sat, sun;

    mon = new DayDto();
    tues = new DayDto();
    wed = new DayDto();
    thurs = new DayDto();
    fri = new DayDto();
    sat = new DayDto();
    sun = new DayDto();

}
