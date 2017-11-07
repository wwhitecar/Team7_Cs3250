package com.team7.app.business.dto;

import org.junit.Before;
import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DayDtoTest {

    DayDto day;
    DayDto dayTwo;

    @Before
    public void before(){
        day = new DayDto("Day Name");
        dayTwo = new DayDto();
    }

    @Test
    public void getDayByNameTest(){
        assertTrue(day.getDayByName().equals("Day Name"));
    }

    @Test
    public void setDayNameTest(){
        assertTrue(day.getDayByName().equals("Day Name"));
        day.setDayName("This is a new name");
        assertTrue(day.getDayByName().equals("This is a new name"));
    }

    @Test
    public void getDbKeyTest() {
        assertNotNull(day.getDbKey());
    }

}
