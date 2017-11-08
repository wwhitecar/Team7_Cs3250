package com.team7.app.business.dto;

import org.junit.Before;
import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ScheduleDtoTest {

    ScheduleDto schedule;
    SectionDto  section;

    @Before
    public void before(){
        schedule = new ScheduleDto("Building Name",section);
    }

    @Test
    public void getScheduleByNameTest(){
        assertTrue(schedule.getScheduleByName().equals("Building Name"));
    }

    @Test
    public void setScheduleNameTest(){
        assertTrue(schedule.getScheduleByName().equals("Building Name"));
        schedule.setScheduleName("This is a new name");
        assertTrue(schedule.getScheduleByName().equals("This is a new name"));
    }

    @Test
    public void getDbKeyTest() {
        assertNotNull(schedule.getDbKey());
    }

}
