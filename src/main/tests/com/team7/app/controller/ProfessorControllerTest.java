package com.team7.app.controller;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.controller.ProfessorController;
import com.team7.app.services.ProfessorServices;
import com.team7.app.services.ProfessorServicesImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyMapOf;
import static org.mockito.Mockito.any;
import com.team7.app.business.dto.ProfessorDto;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorControllerTest {

    @Mock
    ProfessorServicesImpl profMock;

    ProfessorDto prof = new ProfessorDto("Alex","whitlatch", 33);
    ProfessorController professorController;
    Map<String, Object> model;



    @Before
    public void before(){
        professorController = new ProfessorController();
        model = new HashMap<>();
        professorController.professorServices = profMock;
    }

    @Test
    public void ProfessorUpdateTest() {
        List<ProfessorDto> listProf = new ArrayList<>();
        listProf.add(prof);
        when(profMock.listAllProfessor()).thenReturn(listProf);
        assertTrue(professorController.updateProfessorById(33, "Alex", "whitlatch").equals("Successfully updated: <br/>"
                + professorController.readProfessorById(listProf.get(0).getId())));
    }

    @Test
    public void ProfessorCreateTest() {
        List<ProfessorDto> listProf = new ArrayList<>();
        listProf.add(prof);
        when(profMock.listAllProfessor()).thenReturn(listProf);
        assertEquals(professorController.createProfessor(33, "Alex", "whitlatch"),(listProf.get(0).toString() + " Added Successfully <br/> <a href="
                + "/" + ">Go Back to main screen</a>"));
    }

    @Test
    public void ProfessorReadTest() {
        List<ProfessorDto> listProf = new ArrayList<>();
        listProf.add(prof);
        when(profMock.listAllProfessor()).thenReturn(listProf);
        Assert.assertEquals(professorController.readProfessorById(33)),(listProf.get(0).toString() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

}