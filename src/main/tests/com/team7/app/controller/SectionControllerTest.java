package com.team7.app.controller;

import com.team7.app.business.dto.*;
import com.team7.app.services.CourseServicesImpl;
import com.team7.app.services.ProfessorServicesImpl;
import com.team7.app.services.RoomServices;
import com.team7.app.services.SectionServices;
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
public class SectionControllerTest {

    @Mock
    ProfessorServicesImpl profMock;

    @Mock
    CourseServicesImpl courseMock;

    @Mock
    SectionServices sectMock;

    @Mock
    RoomServices roomMock;

    SectionController sectionController;
    CourseDto course;
    ProfessorDto professor;
    SectionDto section;
    RoomDto room;

    @Before
    public void before() {
        sectionController = new SectionController();
        sectionController.setSectionService(sectMock);
        sectionController.setCourseService(courseMock);
        sectionController.setProfessorService(profMock);
        sectionController.setRoomService(roomMock);

        List<DayDto> listy = new ArrayList<>();
        DayDto day = new DayDto("monday");
        listy.add((day));
        day = new DayDto("tuesday");
        listy.add((day));
        day = new DayDto("wednesday");
        listy.add((day));
        day = new DayDto("thursday");
        listy.add((day));
        day = new DayDto("friday");
        listy.add((day));
        day = new DayDto("saturday");
        listy.add((day));
        day = new DayDto("sunday");
        listy.add((day));


        course = new CourseDto("Math", 1234,
                4, "stuff", "other stuff", 0000, 0000);
        professor = new ProfessorDto("Harry", "Hook", 8675309);
        room = new RoomDto(250, 35, "Science Building", new WeekDto(listy));
        section = new SectionDto(1234, course, professor, room);
    }

    @Test
    public void checkConflictsTest(){
        List<ProfessorDto> listy = new ArrayList<>();
        listy.add(professor);
        when(profMock.listAllProfessor()).thenReturn(listy);
        when(profMock.getProfessorById(anyInt())).thenReturn(professor);
        when(courseMock.getCourseById(anyInt())).thenReturn(course);
        when(sectMock.saveSection(anyObject())).thenReturn(section);
        when(roomMock.getRoomByNumber(anyInt())).thenReturn(room);
        assertEquals(section.toString() + " Added Successfully <br/> <a href="
                        + "/" + ">Go Back to main screen</a>",
                sectionController.createSection(1234, 789, "Higher me", 250, "Monday", "900"));
        assertEquals("Conflict, please go back and try again",
                sectionController.createSection(1234, 789, "Higher me", 250, "Monday", "900"));
    }

    @Test
    public void createSectionTest() throws Exception {
        List<ProfessorDto> listy = new ArrayList<>();
        listy.add(professor);
        when(profMock.listAllProfessor()).thenReturn(listy);
        when(profMock.getProfessorById(anyInt())).thenReturn(professor);
        when(courseMock.getCourseById(anyInt())).thenReturn(course);
        when(sectMock.saveSection(anyObject())).thenReturn(section);
        when(roomMock.getRoomByNumber(anyInt())).thenReturn(room);
        assertEquals(sectionController.createSection(1234, 789, "Harry Hook", 250, "", ""), section.toString() + " Added Successfully <br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void readSectionByIdTest() throws Exception {
        when(sectMock.getSectionById(anyInt())).thenReturn(section);

        assertEquals(sectionController.readSectionByNumber(1234), section.toString() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>");

    }

    @Test
    public void updateSectionByIdTest() throws Exception {
        List<ProfessorDto> listy = new ArrayList<>();
        listy.add(professor);
        when(profMock.listAllProfessor()).thenReturn(listy);
        when(profMock.getProfessorById(anyInt())).thenReturn(professor);
        when(courseMock.getCourseById(anyInt())).thenReturn(course);
        when(roomMock.getRoomByNumber(anyInt())).thenReturn(room);
        when(sectMock.saveSection(anyObject())).thenReturn(section);
        when(profMock.listAllProfessor()).thenReturn(listy);
        assertEquals(sectionController.updateSection(1234, 456, "Harry Hook", 250),
                section.toString()
                        + " Updated Section Successfully <br/> <a href="
                        + "/" + ">Go Back to main screen</a>");

    }

    @Test
    public void deleteSectionByIdTest() throws Exception {

        assertEquals(sectionController.deleteCourseByNumber(123), "Removed Section"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }
}