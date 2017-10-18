package com.team7.app.controller;

import com.team7.app.business.dto.StudentDto;
import com.team7.app.services.StudentServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

	@Mock
    private StudentServices mockTemplate;
	StudentController studentController = new StudentController();
	StudentDto student = new StudentDto("Alex","Whitlatch", 33);


    @Test
    public void createStudent() throws Exception {
    }

    @Test
    public void readStudentById() throws Exception {

    }

    @Test
    public void updateStudentById() throws Exception {

    }

    @Test
    public void deleteStudentById() throws Exception {
    }
}