package team7.app.controller;

import com.team7.app.controller.StudentController;
import com.team7.app.services.StudentServices;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyMapOf;

import com.team7.app.business.dto.StudentDto;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

	@Mock
    private StudentServices mockTemplate;
	StudentController studentController = new StudentController();
	StudentDto student = new StudentDto("Alex","Whitlatch", 33);


    @Test
    public void createStudent() throws Exception {
    //    when(studentController.createStudent(anyInt(), anyString(), anyString())).thenReturn(student);
    //   assertEquals(studentController.createStudent(student.getId(),
     //          student.getLastName(), student.getFirstName()), student);
    }

    @Test
    public void readStudentById() throws Exception {
        List<StudentDto> result = new ArrayList<>();
        result.add(student);
      //  when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class), any(UserRowMapper.class))).thenReturn(result);
        //assertEquals(studentController.readUserById(), "Name: Alex Whitlatch" + "\nUser Id: 33");

    }

    @Test
    public void updateStudentById() throws Exception {
     //   assertEquals(studentController.updateUserById(),
     //           "Unable to find user to update, try again with different id.");
	//    assertEquals(studentController.updateUserById(), "Successfully Updated");

    }

    @Test
    public void deleteStudentById() throws Exception {
	 //   assertEquals(studentController.deleteUserById(),
 //               "Unable to remove user, try again with different id");
  //      assertEquals(studentController.deleteUserById(), "Successfully Removed");
    }
}