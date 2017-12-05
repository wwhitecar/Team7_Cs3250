package com.team7.app.controller;

import com.team7.app.business.dto.*;
import com.team7.app.repositories.ProfessorRepository;
import com.team7.app.repositories.RoomRepository;
import com.team7.app.services.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WebPageControllerTest {

    @Mock
    ProfessorRepository profRepo;

    @Mock
    ProfessorServicesImpl profMock;

    @Mock
    CourseServicesImpl courseMock;

    @Mock
    SectionServices sectMock;

    @Mock
    BuildingServices buildingMock;

    @Mock
    RoomServices roomMock;

    @Mock
    SemesterServices semesterMock;

    @Mock
    ScheduleServices scheduleMock;

    @Mock
    DayServices dayMock;

    @Mock
    StudentServices studentMock;

    WebPageController wPC;
    Map<String, Object> model;

    @Before
    public void Before() {
        wPC = new WebPageController();
        model = new HashMap<>();
        wPC.setCourseService(courseMock);
        wPC.setProfessorService(profMock);
        wPC.setSectionService(sectMock);
        wPC.setBuildingService(buildingMock);
        wPC.setRoomService(roomMock);
        wPC.setSemesterService(semesterMock);
        wPC.setScheduleService(scheduleMock);
        wPC.setDayService(dayMock);
        wPC.setStudentService(studentMock);
    }

    @Test
    public void createTest() {
        assertTrue(wPC.create(model).equals( "create"));
    }

    @Test
    public void courseCreateTest() {
        assertTrue(wPC.courseCreate(model).equals("courseCreate"));
    }

    @Test
    public void courseUpdateTest() {
        assertTrue(wPC.courseUpdate(model).equals("courseUpdate"));
    }

    @Test
    public void courseDeleteTest() {
        assertTrue(wPC.courseDelete(model).equals("courseDelete"));
    }

    @Test
    public void courseReadTest() {
        assertTrue(wPC.courseRead(model).equals("courseRead"));
    }

    @Test
    public void deleteTest() {
        assertTrue(wPC.delete(model).equals("delete"));
    }

    @Test
    public void indexTest() {
        assertTrue(wPC.index(model).equals("index"));
    }

    @Test
    public void professorCreateTest() {
        assertTrue(wPC.professorCreate(model).equals("professorCreate"));
    }

    @Test
    public void professorDeleteTest() {
        assertTrue(wPC.professorDelete(model).equals("professorDelete"));
    }

    @Test
    public void professorReadTest() {
        assertTrue(wPC.professorRead(model).equals("professorRead"));
    }

    @Test
    public void professorUpdateTest() {
        assertTrue(wPC.professorUpdate(model).equals("professorUpdate"));
    }

    @Test
    public void readTest() {
        assertTrue(wPC.read(model).equals("read"));
    }

    @Test
    public void updateTest() {
        assertTrue(wPC.update(model).equals("update"));
    }

    @Test
    public void sectionUpdateTest() {
        List<CourseDto> listCourse = new ArrayList();
        listCourse.add(new CourseDto());
        List<ProfessorDto> listProf = new ArrayList<>();
        List<RoomDto> listRoom = new ArrayList<>();
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        when(roomMock.listAllRoom()).thenReturn(listRoom);
        assertTrue(wPC.sectionUpdate(model).equals("sectionUpdate"));
    }

    @Test
    public void sectionCreateTest() {
        List<CourseDto> listCourse = new ArrayList();
        listCourse.add(new CourseDto());
        List<ProfessorDto> listProf = new ArrayList<>();
        List<RoomDto> listRoom = new ArrayList<>();
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        when(roomMock.listAllRoom()).thenReturn(listRoom);
        assertTrue(wPC.sectionCreate(model).equals("sectionCreate"));
    }

    @Test
    public void sectionReadTest() {
        List<CourseDto> listCourse = new ArrayList();
        listCourse.add(new CourseDto());
        List<ProfessorDto> listProf = new ArrayList<>();
        List<RoomDto> listRoom = new ArrayList<>();
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        when(roomMock.listAllRoom()).thenReturn(listRoom);
        assertTrue(wPC.sectionRead(model).equals("sectionRead"));
    }

    @Test
    public void sectionDeleteTest() {
        List<CourseDto> listCourse = new ArrayList();
        listCourse.add(new CourseDto());
        List<ProfessorDto> listProf = new ArrayList<>();
        List<RoomDto> listRoom = new ArrayList<>();
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        when(roomMock.listAllRoom()).thenReturn(listRoom);
        assertTrue(wPC.sectionDelete(model).equals("sectionDelete"));
    }

    @Test
    public void createBuildingTest(){
        assertEquals(wPC.createBuilding(model), "buildingCreate");
    }

    @Test
    public void readBuildingTest(){
        assertEquals(wPC.readBuilding(model), "buildingRead");
    }

    @Test
    public void updateBuildingTest(){
        List<BuildingDto> buildingList = new ArrayList<>();
        when(buildingMock.listAllBuilding()).thenReturn(buildingList);
        assertEquals(wPC.updateBuilding(model), "buildingUpdate");
    }

    @Test
    public void deleteBuildingTest() {
        List<BuildingDto> buildingList = new ArrayList<>();
        when(buildingMock.listAllBuilding()).thenReturn(buildingList);
        assertEquals(wPC.deleteBuilding(model), "buildingDelete");
    }

    @Test
    public void createSemesterTest(){
        assertEquals(wPC.createSemester(model), "semesterCreate");
    }

    @Test
    public void readSemesterTest(){
        assertEquals(wPC.readSemester(model), "semesterRead");
    }

    @Test
    public void updateSemesterTest(){
        List<SemesterDto> semesterList = new ArrayList<>();
        when(semesterMock.listAllSemesters()).thenReturn(semesterList);
        assertEquals(wPC.updateSemester(model), "semesterUpdate");
    }

    @Test
    public void deleteSemesterTest() {
        List<SemesterDto> semesterList = new ArrayList<>();
        when(semesterMock.listAllSemesters()).thenReturn(semesterList);
        assertEquals(wPC.deleteSemester(model), "semesterDelete");
    }

    @Test
    public void createRoomTest(){
        List<BuildingDto> buildingList = new ArrayList<>();
        when(buildingMock.listAllBuilding()).thenReturn(buildingList);
        assertEquals(wPC.createRoom(model), "roomCreate");
    }

    @Test
    public void deleteRoomTest(){
        assertEquals(wPC.deleteRoom(model), "roomDelete");
    }

    @Test
    public void updateRoomTest(){
        List<BuildingDto> buildingList = new ArrayList<>();
        when(buildingMock.listAllBuilding()).thenReturn(buildingList);
        assertEquals(wPC.updateRoom(model), "roomUpdate");
    }

    @Test
    public void readRoomTest(){
        assertEquals(wPC.readRoom(model), "roomRead");
    }

    @Test
    public void createScheduleTest(){
        assertEquals(wPC.createSchedule(model), "scheduleCreate");
    }

    @Test
    public void readScheduleTest(){
    List<StudentDto> studentList = new ArrayList<>();
    when(studentMock.listAllStudent()).thenReturn(studentList);
    assertEquals(wPC.readSchedule(model),"scheduleRead");
    }

    @Test
    public void updateScheduleTest(){
        List<ScheduleDto> scheduleList = new ArrayList<>();
        when(scheduleMock.listAllSchedule()).thenReturn(scheduleList);
        assertEquals(wPC.updateSchedule(model), "scheduleUpdate");
    }

    @Test
    public void deleteScheduleTest() {
        List<ScheduleDto> scheduleList = new ArrayList<>();
        when(scheduleMock.listAllSchedule()).thenReturn(scheduleList);
        assertEquals(wPC.deleteSchedule(model), "scheduleDelete");
    }

    @Test
    public void deleteDayTest() {
        assertEquals(wPC.deleteDay(model), "dayDelete");
    }

    @Test
    public void updateDayTest(){
        List<DayDto> listy = new ArrayList<>();
        when(dayMock.listAllDays()).thenReturn(listy);
        assertEquals(wPC.updateDay(model), "dayUpdate");

    }

    @Test
    public void readDayTest() {
        assertEquals(wPC.readDay(model), "dayRead");
    }

    @Test
    public void createDayTest() {
        List<DayDto> listy = new ArrayList<>();
        when(dayMock.listAllDays()).thenReturn(listy);
        assertEquals(wPC.createDay(model), "dayCreate");
    }

    @Test
    public void registerStudentTest() {
        assertEquals(wPC.registerStudent(model), "registerStudent");
    }
}