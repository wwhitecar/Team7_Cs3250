package com.team7.app.controller;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.services.CourseServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

    @Mock
    private NamedParameterJdbcTemplate mockTemplate;

    @Mock
    CourseServicesImpl courseMock;

    CourseController courseController = new CourseController();

    CourseDto course;

    @Before
    public void before(){
        courseController.courseServices = courseMock;
        course = new CourseDto("Math", 1234,
                4, "stuff", "other stuff", 0000, 0000);
    }

    @Test
    public void createCourseTest(){
       assertEquals(courseController.createCourse("Math", 1234,
               4, "stuff", "other stuff", 0000, 0000), "Unable to create Course, <br/> <a href=" +
               "/" + ">Go Back to main screen</a>");

       when (courseMock.saveCourse(anyObject())).thenReturn(course);
       assertEquals(courseController.createCourse("Math", 1234,
               4, "stuff", "other stuff", 0000, 0000),
               course.toString() + " Added Successfully <br/> <a href="
               + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void updateCourseTest(){
        assertEquals(courseController.updateCourseByNumber("Math", 1234,
                4, "stuff", "other stuff", 0000, 0000), "Unable to find Course");

        when(courseMock.saveCourse(anyObject())).thenReturn(course);
        assertEquals(courseController.updateCourseByNumber("Math", 1234,
                4, "stuff", "other stuff", 0000, 0000),
                course.toString() + " Updated Successfully <br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void deleteCourseTest(){
        assertEquals(courseController.deleteCourseByNumber(1234), "Removed Course"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }

    @Test
    public void readCourseTest(){
        assertEquals(courseController.readCourseByNumber(1234), "Unable to find Course");
        when(courseMock.getCourseById(anyInt())).thenReturn(course);
        assertEquals(courseController.readCourseByNumber(1234), course.toString() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }
}
