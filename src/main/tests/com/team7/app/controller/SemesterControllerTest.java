package com.team7.app.controller;

import com.team7.app.business.dto.SemesterDto;
import com.team7.app.services.SemesterServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SemesterControllerTest {

    @Mock
    SemesterServicesImpl semesterMock;

    SemesterController controller;
    SemesterDto semester;

    @Before
    public void before(){
        controller = new SemesterController();
        semester = new SemesterDto("Spring 2002");
        controller.setSemesterService(semesterMock);
    }

    @Test
    public void createSemesterTest(){
        when(semesterMock.saveSemester(anyObject())).thenReturn(semester);

        assertEquals(controller.createSemester("Spring 2020"),
                "Successfully created semester <br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void updateSemesterTest(){
        List<SemesterDto> listy = new ArrayList<>();
        listy.add(semester);
        when(semesterMock.listAllSemesters()).thenReturn(listy);
        when(semesterMock.saveSemester(anyObject())).thenReturn(semester);

        assertEquals(controller.updateSemester("Spring 2002", "New Name"),
                "Successfully updated semester <br/> <a href="
                        + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void readSemesterTest(){
        List<SemesterDto> listy = new ArrayList<>();
        listy.add(semester);
        when(semesterMock.listAllSemesters()).thenReturn(listy);

        assertEquals(controller.readSemester("Spring 2002"), semester.getSemesterName() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>" );
    }

    @Test
    public void deleteSemesterTest(){
        List<SemesterDto> listy = new ArrayList<>();
        listy.add(semester);
        when(semesterMock.listAllSemesters()).thenReturn(listy);

        controller.deleteSemester("Spring 2002");
    }
}