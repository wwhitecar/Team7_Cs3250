package com.team7.app.business.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SemesterTest {

    SemesterDto semester;
    SemesterDto semesterTwo;
    ScheduleDto schedule;

    @Before
    public void before(){
        schedule = new ScheduleDto();
        semester = new SemesterDto();
        semesterTwo = new SemesterDto("Fall 2020");

    }

    @Test
    public void getDbKeyTest(){
        assertTrue(semester.getDbKey() == 0);
    }

    @Test
    public void getSchedualTest(){
        assertEquals(semesterTwo.getSemesterName(), "Fall 2020");
    }

    @Test
    public void getSectionsTest() {
        assertNotNull(semesterTwo.getSections());
    }
}