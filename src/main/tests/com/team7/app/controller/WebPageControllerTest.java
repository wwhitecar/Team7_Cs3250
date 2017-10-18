package com.team7.app.controller;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.controller.WebPageController;
import com.team7.app.repositories.CourseRepository;
import com.team7.app.repositories.ProfessorRepository;
import com.team7.app.services.CourseServicesImpl;
import com.team7.app.services.ProfessorServicesImpl;
import com.team7.app.services.SectionServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class WebPageControllerTest {

    @Mock
    CourseRepository cRepo;

    @Mock
    ProfessorRepository profRepo;

    @Mock
    ProfessorServicesImpl profMock;

    @Mock
    CourseServicesImpl courseMock;
    @Mock
    SectionServices sectMock;

    WebPageController wPC;
    Map<String, Object> model;

    @Before
    public void Before() {
        wPC = new WebPageController();
        model = new HashMap<>();
        wPC.courseServices = courseMock;
        wPC.professorServices = profMock;
        wPC.sectionServices = sectMock;
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
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        assertTrue(wPC.sectionUpdate(model).equals("sectionUpdate"));
    }

    @Test
    public void sectionCreateTest() {
        List<CourseDto> listCourse = new ArrayList();
        listCourse.add(new CourseDto());
        List<ProfessorDto> listProf = new ArrayList<>();
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        assertTrue(wPC.sectionCreate(model).equals("sectionCreate"));
    }

    @Test
    public void sectionReadTest() {
        List<CourseDto> listCourse = new ArrayList();
        listCourse.add(new CourseDto());
        List<ProfessorDto> listProf = new ArrayList<>();
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        assertTrue(wPC.sectionRead(model).equals("sectionRead"));
    }

    @Test
    public void sectionDeleteTest() {
        List<CourseDto> listCourse = new ArrayList();
        listCourse.add(new CourseDto());
        List<ProfessorDto> listProf = new ArrayList<>();
        when(profMock.listAllProfessor()).thenReturn(listProf);
        when(courseMock.listAllCourse()).thenReturn(listCourse);
        when(profRepo.findAll()).thenReturn(listProf);
        assertTrue(wPC.sectionDelete(model).equals("sectionDelete"));
    }

}