package com.team7.app.controller;

import com.team7.app.business.dto.StudentDto;
import com.team7.app.services.StudentServicesImpl;
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
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
    @Mock
    StudentServicesImpl studentMock;

    StudentDto student = new StudentDto("Alex","whitlatch", 33);
    StudentController studentController;
    Map<String, Object> model;



    @Before
    public void before(){
        studentController = new StudentController();
        model = new HashMap<>();
        studentController.studentServices = studentMock;
    }

    @Test
    public void StudentUpdateTest() {
        List<StudentDto> listStudent = new ArrayList<>();
        listStudent.add(student);
        when(studentMock.listAllStudent()).thenReturn(listStudent);
        assertTrue(studentController.updateStudentById(33, "Alex", "whitlatch").equals("Successfully updated: <br/>"
                + studentController.readStudentById(listStudent.get(0).getId())));
    }

    @Test
    public void StudentCreateTest() {
        List<StudentDto> listStudent = new ArrayList<>();
        listStudent.add(student);
        assertEquals(studentController.createStudent(33, "Alex", "whitlatch"),("Error adding Student for some reason"));
       when (studentMock.saveStudent(anyObject())).thenReturn(student);
        assertEquals(studentController.createStudent(33, "Alex", "whitlatch"),(listStudent.get(0).toString()  + " Added Successfully <br/> <a href="
                + "/" + ">Go Back to main screen</a>"));
    }

    @Test
    public void StudentReadTest() {
        assertEquals(studentController.readStudentById(33),("Unable to find Student"));
        when(studentMock.getStudentById(anyInt())).thenReturn(student);
        assertEquals(studentController.readStudentById(33), student.toString() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void deleteStudentTest(){
        assertEquals(studentController.deleteStudentById(33),"Removed Student"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }
}