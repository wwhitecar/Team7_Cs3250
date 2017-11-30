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
    StudentServicesImpl studentMock;

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
    StudentDto student;

    @Before
    public void before() {
        student = new StudentDto("Alex", "Whitlatch", 45678);
        course = new CourseDto("Computer Science", 3210, 4,
                "Learn stuffs", "Be better at computer", 0000, 0000);
        professor = new ProfessorDto("Donald", "Trump", 123);
        room = new RoomDto(250, 35, "Science Building");
        section = new SectionDto(123, course, professor, room);
        schedule = new ScheduleDto(student, section);
        scheduleController.setScheduleServices(scheduleMock);
        scheduleController.setSectionService(sectMock);
        scheduleController.setStudentServices(studentMock);

    }

    @Test
    public void createSchedule() throws Exception {
        assertEquals(scheduleController.createSchedule("Student ID 0", "Section Number 0"),
                ("Unable to create Schedule" + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));

        when(scheduleMock.saveSchedule(anyObject())).thenReturn(schedule);
        assertEquals(scheduleController.createSchedule("Student ID 1", "Section Number 1"),
                ("Successfully created Schedule"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

    @Test
    public void readScheduleByName() throws Exception {
        List<ScheduleDto> listy = new ArrayList<>();
        listy.add(schedule);
        when(scheduleMock.listAllSchedule()).thenReturn(listy);
        when(scheduleMock.getScheduleByName(anyInt())).thenReturn(schedule);
        assertEquals(scheduleController.readScheduleByName("Student ID: 45678 Alex Whitlatch"),
                "SCHEDULE INFORMATION</br>Section 1 </br>Section Number: 123</br>Course Information:</br>Department: Computer Science</br>Course Number: 3210</br>Course Description: Learn stuffs</br>Learning Objective :Be better at computer</br>Credits:4</br>Professor Information: </br> First Name: Donald</br>Last Name: Trump </br> </br> </br> Total Number of Credits this semester: 4");
    }

    @Test
    public void deleteScheduleByName() throws Exception {
        List<ScheduleDto> listy = new ArrayList<>();
        listy.add(schedule);
        when(scheduleMock.listAllSchedule()).thenReturn(listy);

        assertEquals(scheduleController.deleteScheduleByName("Student ID: 45678 First Name: Alex Last Name: Whitlatch Section Number: 123"),
               ("Removed Schedule"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

}