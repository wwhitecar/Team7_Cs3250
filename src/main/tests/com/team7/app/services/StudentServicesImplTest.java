package com.team7.app.services;

import com.team7.app.business.dto.StudentDto;
import com.team7.app.repositories.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServicesImplTest {

    @Mock
    StudentRepository sRepo;
    StudentServicesImpl studServ;

    @Before
    public void before() {
        studServ = new StudentServicesImpl();
        studServ.setStudentService(sRepo);
    }

    @Test
    public void listAllProfessorList(){
        Iterable<StudentDto> studentList = new ArrayList<>();
        when(sRepo.findAll()).thenReturn(studentList);
        assertNotNull(studServ.listAllStudent());
    }

    @Test
    public void getCourseByIdTest(){
        StudentDto student = new StudentDto();

        when(sRepo.findOne(anyInt())).thenReturn(student);
        assertNotNull(studServ.getStudentById(123));
    }

    @Test
    public void saveCourseTest(){
        StudentDto student = new StudentDto();
        when(sRepo.save(student)).thenReturn(student);
        assertNotNull(studServ.saveStudent(student));
    }

    @Test
    public void deleteCourseTest(){
        studServ.deleteStudent(123);
    }
}