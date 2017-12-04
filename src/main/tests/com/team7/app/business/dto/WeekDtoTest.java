package com.team7.app.business.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeekDtoTest {

    WeekDto week;


    @Before
    public void before () {
        List<DayDto> listy = new ArrayList<>();
        DayDto day = new DayDto("Monday");
        listy.add((day));
        day = new DayDto("Tuesday");
        listy.add((day));
        day = new DayDto("Wednesday");
        listy.add((day));
        day = new DayDto("Thursday");
        listy.add((day));
        day = new DayDto("Friday");
        listy.add((day));
        day = new DayDto("Saturday");
        listy.add((day));
        day = new DayDto("Sunday");
        listy.add((day));
        week = new WeekDto(listy);
    }

    @Test
    public void getDayofWeekTest () {
        assertEquals(week.getDayofWeek("not a day"), null);
    }

}