package com.team7.app.services;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.repositories.CourseRepository;
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
public class CourseServicesImplTest {

    @Mock
    CourseRepository cRepo;
    CourseServicesImpl courseServ;

    @Before
    public void before(){
        courseServ = new CourseServicesImpl();
        courseServ.courseRepository = cRepo;
    }

    @Test
    public void listAllCoursesList(){
        Iterable<CourseDto> courseList = new ArrayList<>();
        when(cRepo.findAll()).thenReturn(courseList);
        assertNotNull(courseServ.listAllCourse());
    }

    @Test
    public void getCourseByIdTest(){
        CourseDto course = new CourseDto();

        when(cRepo.findOne(anyInt())).thenReturn(course);
        assertNotNull(courseServ.getCourseById(123));
    }

    @Test
    public void saveCourseTest(){
        CourseDto course = new CourseDto();
        when(cRepo.save(course)).thenReturn(course);
        assertNotNull(courseServ.saveCourse(course));
    }

    @Test
    public void deleteCourseTest(){
        courseServ.deleteCourse(123);
    }
}
