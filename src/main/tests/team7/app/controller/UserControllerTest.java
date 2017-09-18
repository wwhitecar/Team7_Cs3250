package team7.app.controller;

import com.team7.app.controller.UserController;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

	@Before
	public void before(){
        userController.namedJdbcTemplate = mockTemplate; // Made mock object of a jdbc template
    }

    @Test
    public void createUser() throws Exception {
            	userController.createUser(1, "tom", "Bradey");
    }

    @Test
    public void readUserById() throws Exception {
        List<UserDto> result =new ArrayList<>();
        result.add(new UserDto());
        when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class), any(UserRowMapper.class))).thenReturn(result);
        userController.readUserById(33);
    }

    @Test
    public void updateUserById() throws Exception {
	    userController.updateUserById(33, "Alex", "Whitlatch");
    }

    @Test
    public void deleteUserById() throws Exception {
        userController.deleteUserById(33);
    }
}