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
    SectionServices sectMock;

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
        schedule = new ScheduleDto("Schedule Name", section);
        sectionController = new SectionController();
        sectionController.setSectionService(sectMock);
        sectionController.setCourseService(courseMock);
        sectionController.setProfessorService(profMock);
        sectionController.setRoomService(roomMock);


        course = new CourseDto("Math", 1234,
                4, "stuff", "other stuff", 0000, 0000);
        professor = new ProfessorDto("Harry", "Hook", 8675309);
        room = new RoomDto(250, 35, "Science Building");
        section = new SectionDto(1234, course, professor, room);
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

//    @Test
//    public void updateBuilding() throws Exception {
//        List<BuildingDto> listy = new ArrayList<>();
//        listy.add(building);
//        when(buildingMock.listAllBuilding()).thenReturn(listy);
//        when(buildingMock.getBuildingByName(anyInt())).thenReturn(building);
//        assertEquals(buildingController.updateBuilding("Building Name", "New Building Name"),
//                ("Successfully Updated" + "<br/> <a href=" + "/"
//                        + ">Go Back to main screen</a>"));
//    }
//
//    @Test
//    public void readBuildingByName() throws Exception {
//        List<BuildingDto> listy = new ArrayList<>();
//        listy.add(building);
//        when(buildingMock.listAllBuilding()).thenReturn(listy);
//        when(buildingMock.getBuildingByName(anyInt())).thenReturn(building);
//        assertEquals(buildingController.readBuildingByName("Building Name"),
//                building.toString());
//    }
//
//    @Test
//    public void deleteBuildingByName() throws Exception {
//        List<BuildingDto> listy = new ArrayList<>();
//        listy.add(building);
//        when(buildingMock.listAllBuilding()).thenReturn(listy);
//
//        assertEquals(buildingController.deleteBuildingByName("Building Name"),
//                ("Removed Building"
//                        + "<br/> <a href=" + "/"
//                        + ">Go Back to main screen</a>"));
//    }

}