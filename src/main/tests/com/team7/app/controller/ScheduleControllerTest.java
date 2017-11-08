package com.team7.app.controller;

import com.team7.app.business.dto.*;
import com.team7.app.services.*;
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
public class ScheduleControllerTest {

    @Mock
    ProfessorServicesImpl profMock;

    @Mock
    CourseServicesImpl courseMock;

    @Mock
    SectionServicesImpl sectMock;

    @Mock
    RoomServices roomMock;

    @Mock
    ScheduleServicesImpl scheduleMock;

    ScheduleController scheduleController = new ScheduleController();

    ScheduleDto schedule;

    SectionController sectionController;
    CourseDto course;
    ProfessorDto professor;
    SectionDto section;
    RoomDto room;

    @Before
    public void before() {

        scheduleController.setScheduleServices(scheduleMock);
        scheduleController.setSectionService(sectMock);
        schedule = new ScheduleDto("Schedule Name", section);
    }

    @Test
    public void createSchedule() throws Exception {
        assertEquals(scheduleController.createSchedule("Building Name", 3),
                ("Unable to create Schedule" + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));

        when(scheduleMock.saveSchedule(anyObject())).thenReturn(schedule);
        assertEquals(scheduleController.createSchedule("Schedule Name", 70),
                ("Successfully created Schedule"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

    @Test
    public void updateSchedule() throws Exception {
        List<ScheduleDto> listy = new ArrayList<>();
        listy.add(schedule);
        when(scheduleMock.listAllSchedule()).thenReturn(listy);
        when(scheduleMock.getScheduleByName(anyInt())).thenReturn(schedule);
        assertEquals(scheduleController.updateSchedule("Building Name", "New Building Name"),
                ("Successfully Updated" + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

    @Test
    public void readScheduleByName() throws Exception {
        List<ScheduleDto> listy = new ArrayList<>();
        listy.add(schedule);
        when(scheduleMock.listAllSchedule()).thenReturn(listy);
        when(scheduleMock.getScheduleByName(anyInt())).thenReturn(schedule);
        assertEquals(scheduleController.readScheduleByName("Building Name"),
                schedule.toString());
    }

    @Test
    public void deleteScheduleByName() throws Exception {
        List<ScheduleDto> listy = new ArrayList<>();
        listy.add(schedule);
        when(scheduleMock.listAllSchedule()).thenReturn(listy);

        assertEquals(scheduleController.deleteScheduleByName("Schedule Name"),
               ("Removed Schedule"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

}