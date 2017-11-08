package com.team7.app.controller;

import com.team7.app.business.dto.DayDto;
import com.team7.app.services.DayServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DayControllerTest {

    @Mock
    DayServicesImpl dayMock;

    DayController dayController = new DayController();

    DayDto day;

    @Before
    public void before(){
        dayController.setDaysServices(dayMock);
        day = new DayDto("Day Name");
    }

    @Test
    public void createDay() throws Exception {
        assertEquals(dayController.createDay("Day Name"),
                ("Unable to create Builing" + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));

        when(dayMock.saveDay(anyObject())).thenReturn(day);
        assertEquals(dayController.createDay("Day Name"),
                ("Successfully created day"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

    @Test
    public void updateDay() throws Exception {
        List<DayDto> dayList = new ArrayList<>();
        dayList.add(day);
        when(dayMock.listAllDays()).thenReturn(dayList);
        when(dayMock.getDayByName(anyInt())).thenReturn(day);
        assertEquals(dayController.updateDay("Day Name", "New Day Name"),
                ("Successfully Updated" + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

    @Test
    public void readDayByName() throws Exception {
        List<DayDto> listy = new ArrayList<>();
        listy.add(day);
        when(dayMock.listAllDays()).thenReturn(listy);
        when(dayMock.getDayByName(anyInt())).thenReturn(day);
        assertEquals(dayController.readDayByName("Day Name"),
                day.toString());
    }

    @Test
    public void deleteDayByName() throws Exception {
        List<DayDto> listy = new ArrayList<>();
        listy.add(day);
        when(dayMock.listAllDays()).thenReturn(listy);

        assertEquals(dayController.deleteDayByName("Day Name"),
                ("Removed Day"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

}