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
    public void checkCreation(){
        assertNotNull(courseController);
    }
}
