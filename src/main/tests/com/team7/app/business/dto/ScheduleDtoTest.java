package com.team7.app.business.dto;

import org.junit.Before;
import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ScheduleDtoTest {

    ScheduleDto schedule;
    SectionDto  section;
    StudentDto student;

    @Before
    public void before(){
        schedule = new ScheduleDto(student,section);
    }


    @Test
    public void getDbKeyTest() {
        assertNotNull(schedule.getDbKey());
    }

}
