package team7.app.controller;

import com.team7.app.controller.StudentController;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyMapOf;
import static org.mockito.Mockito.any;
import com.team7.app.business.UserRowMapper;
import com.team7.app.business.dto.StudentDto;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
    private NamedParameterJdbcTemplate mockTemplate;
	StudentController studentController = new StudentController();
	StudentDto user = new StudentDto("Alex","Whitlatch", 33);

	@Before
	public void before(){
            }

    @Test
    public void createUser() throws Exception {
        assertEquals(studentController.createUser(), "Success");
    }

    @Test
    public void readUserById() throws Exception {
        List<StudentDto> result = new ArrayList<>();
        result.add(user);
        when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class), any(UserRowMapper.class))).thenReturn(result);
        assertEquals(studentController.readUserById(), "Name: Alex Whitlatch" + "\nUser Id: 33");

    }

    @Test
    public void updateUserById() throws Exception {
        assertEquals(studentController.updateUserById(),
                "Unable to find user to update, try again with different id.");
	    when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
	    assertEquals(studentController.updateUserById(), "Successfully Updated");

    }

    @Test
    public void deleteUserById() throws Exception {
	    assertEquals(studentController.deleteUserById(),
                "Unable to remove user, try again with different id");
	    when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(studentController.deleteUserById(), "Successfully Removed");
    }
}