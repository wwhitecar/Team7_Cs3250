package com.team7.app.controller;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.controller.CourseController;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyMapOf;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

    @Mock
    private NamedParameterJdbcTemplate mockTemplate;
    CourseController courseController = new CourseController();

    @Before
    public void before(){
    }

    @Test
    public void createCourseTest(){
        assertTrue(courseController.createCourse("CS", 3250,
                8, "Wish a course was worth 8 creds",
                "Don't matter 8 credit swill be a fail :)",
                0000, 0000).equals("Success"));
    }

    @Test
    public void updateCourseTest(){
        assertTrue(courseController.updateCourseByNumber("CS", 3250,
                8, "Wish a course was worth 8 creds",
                "Don't matter 8 credit swill be a fail :)",
                0000, 0000)
                .equals("Failed to find the course you are trying to update, please try again."));

        when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(courseController.updateCourseByNumber("Math", 3250, 4, "Learn how to triangle",
                "Be better at math", 0000, 0000),  "Successfully Updated");
    }

    @Test
    public void deleteCourseTest(){
        assertTrue(courseController.deleteCourseByNumber(3250)
                .equals("Unable to find course to remove, please try again"));

        when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(courseController.deleteCourseByNumber(3250), "Successfully Removed");
    }

    @Test
    public void readCourseTest(){
        assertTrue(true);

        CourseDto course = new CourseDto("CS", 3250,
                8, "Wish a course was worth 8 creds",
                "Don't matter 8 credits will be a fail :)",
                0000, 0000);

        List<CourseDto> result = new ArrayList<>();
        result.add(course);
//        when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class),
  //              any(CourseRowMapper.class))).thenReturn(result);

        assertEquals(courseController.readCourseByNumber(3250), "");
    }
}
