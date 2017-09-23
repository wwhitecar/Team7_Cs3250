package team7.app.controller;

import com.team7.app.controller.CourseController;
import com.team7.app.controller.UserController;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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
    }

    @Test
    public void deleteCourseTest(){
        assertTrue(courseController.deleteCourseByNumber(3250)
                .equals("Unable to find course to remove, please try again"));
    }

    @Test
    public void readCourseTest(){
        assertTrue(courseController.readCourseByNumber(3250)
                .equals("Course not found, please try again with another Course Number"));
    }
}
