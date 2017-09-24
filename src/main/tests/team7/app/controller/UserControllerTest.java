package team7.app.controller;

import com.team7.app.controller.UserController;
import org.junit.Assert;
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
import com.team7.app.business.dto.UserDto;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
    private NamedParameterJdbcTemplate mockTemplate;
	UserController userController = new UserController();
	UserDto user = new UserDto("Alex","Whitlatch", 33);

	@Before
	public void before(){
        userController.namedJdbcTemplate = mockTemplate; // Made mock object of a jdbc template
    }

    @Test
    public void createUser() throws Exception {
        assertEquals(userController.createUser(33, "Alex", "Whitlatch"), "Success");
    }

    @Test
    public void readUserById() throws Exception {
        List<UserDto> result = new ArrayList<>();
        result.add(user);
        when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class), any(UserRowMapper.class))).thenReturn(result);
        assertEquals(userController.readUserById(33), "Name: Alex Whitlatch" + "\nUser Id: 33");

    }

    @Test
    public void updateUserById() throws Exception {
        assertEquals(userController.updateUserById(33, "Alex", "Whitlatch"),
                "Unable to find user to update, try again with different id.");
	    when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
	    assertEquals(userController.updateUserById(33, "Trevor", "Whitecar"), "Successfully Updated");

    }

    @Test
    public void deleteUserById() throws Exception {
	    assertEquals(userController.deleteUserById(33),
                "Unable to remove user, try again with different id");
	    when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(userController.deleteUserById(33), "Successfully Removed");
    }
}