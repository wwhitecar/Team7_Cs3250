package team7.app.business.dto;

import com.team7.app.business.dto.UserDto;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserDtoTest {

    @Test
    public void getFirstName() throws Exception {
        UserDto user = new UserDto("First Name", "Last Name", 3322);
        UserDto user2 = new UserDto();
        assertEquals("First Name", user.getFirstName());
        assertEquals(null, user2.getLastName());
    }

    @Test
    public void getLastName() throws Exception {
        UserDto user = new UserDto("First name", "Last Name", 3322);
        UserDto user2 = new UserDto();
        assertEquals("Last Name", user.getLastName());
        assertEquals(null, user2.getLastName());
        }

    @Test
    public void getId() throws Exception {
        UserDto user = new UserDto("First name", "Last Name", 3322);
        UserDto user2 = new UserDto();
        assertEquals(user.getId(), 3322);
        assertEquals(0, user2.getId());
        }
}