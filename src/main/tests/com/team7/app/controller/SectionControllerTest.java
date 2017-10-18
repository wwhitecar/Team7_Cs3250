package com.team7.app.controller;

import com.team7.app.repositories.ProfessorRepository;
import com.team7.app.services.CourseServicesImpl;
import com.team7.app.services.ProfessorServicesImpl;
import com.team7.app.services.SectionServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SectionControllerTest {


    @Mock
    ProfessorRepository profRepo;

    @Mock
    ProfessorServicesImpl profMock;

    @Mock
    CourseServicesImpl courseMock;

    @Mock
    SectionServices sectMock;

    SectionController sectionController;

    @Before
    public void before() {
        sectionController = new SectionController();
        sectionController.sectionServices = sectMock;
        sectionController.courseServices = courseMock;
        sectionController.professorServices = profMock;
    }

    @Test
    public void createSectionTest() throws Exception {
    }

    @Test
    public void readSectionByIdTest() throws Exception {

    }

    @Test
    public void updateSectionByIdTest() throws Exception {

    }

    @Test
    public void deleteSectionByIdTest() throws Exception {
    }
}