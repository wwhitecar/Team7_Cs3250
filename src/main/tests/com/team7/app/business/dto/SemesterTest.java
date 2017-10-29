package com.team7.app.business.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SemesterTest {

    SemesterDto semester;
    SemesterDto semesterTwo;
    ScheduleDto schedule;

    @Before
    public void before(){
        schedule = new ScheduleDto();
        semester = new SemesterDto(null);
        semesterTwo = new SemesterDto(schedule);

    }

    @Test
    public void getDbKeyTest(){
        assertTrue(semester.getDbKey() == 0);
    }

    @Test(expected = NullPointerException.class)
    public void getSchedualTest(){
        assertEquals(semesterTwo.getSchedule(), schedule);
        assertTrue(semester.getSchedule() == null);
    }
}