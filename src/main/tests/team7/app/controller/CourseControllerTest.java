package team7.app.controller;

import com.team7.app.business.CourseRowMapper;
import com.team7.app.business.dto.CourseDto;
import com.team7.app.controller.CourseController;
import com.team7.app.controller.UserController;
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
import com.team7.app.business.UserRowMapper;
import com.team7.app.business.dto.UserDto;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

    @Mock
    private NamedParameterJdbcTemplate mockTemplate;
    CourseController courseController = new CourseController();

    @Before
    public void before(){
        courseController.namedJdbcTemplate = mockTemplate; // Made mock object of a jdbc template
    }

    @Test
    public void createCourseTest(){
        assertTrue(courseController.createCourse("CS", 3250,
                8, "Wish a course was worth 8 creds",
                "Don't matter 8 credit swill be a fail :)",
                "Junior", null).equals("Success"));
    }

    @Test
    public void updateCourseTest(){
        assertTrue(courseController.updateCourseByNumber("CS", 3250,
                8, "Wish a course was worth 8 creds",
                "Don't matter 8 credit swill be a fail :)",
                "Junior", null)
                .equals("Failed to find the course you are trying to update, please try again."));

        when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(courseController.updateCourseByNumber("Math", 3250, 4, "Learn how to triangle",
                "Be better at math", "Freshman", null),  "Successfully Updated");
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
        assertTrue(courseController.readCourseByNumber(3250)
                .equals("Course not found, please try again with another Course Number"));

        CourseDto course = new CourseDto("CS", 3250,
                8, "Wish a course was worth 8 creds",
                "Don't matter 8 credits will be a fail :)",
                "Junior", null);

        List<CourseDto> result = new ArrayList<>();
        result.add(course);
        when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class),
                any(CourseRowMapper.class))).thenReturn(result);

        assertEquals(courseController.readCourseByNumber(3250), ("Course Information: \r\n Dept: CS"
                + "\r\n Course Number: 3250" + "\r\n Credits : 8"
                + "\r\n Description: Wish a course was worth 8 creds"
                + "\r\n Learning Objective: Don't matter 8 credits will be a fail :)"
                + "\r\n Prereqs: Junior"
                + "\r\n Coreqs: null"));
    }
}
