package com.team7.app.controller;

import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.services.ProfessorServicesImpl;
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
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

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
        professorController.setProfessorService(profMock);
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
        assertEquals(professorController.readProfessorById(33),("Unable to find Professor"));
        when(profMock.getProfessorById(anyInt())).thenReturn(prof);
        assertEquals(professorController.readProfessorById(33), prof.toString() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void deleteProfessorTest(){
        assertEquals(professorController.deleteProfessorById(33),"Removed Professor"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }

}