package team7.app.business.dto;

import com.team7.app.business.dto.StudentDto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentDtoTest {

    StudentDto student;
    StudentDto student2;

    @Before
    public void before(){
        student = new StudentDto("First Name", "Last Name", 3322);
        student2 = new StudentDto();
    }

    @Test
    public void getFirstName() throws Exception {

        assertEquals("First Name", student.getFirstName());
        assertEquals(null, student2.getLastName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("Last Name", student.getLastName());
        assertEquals(null, student2.getLastName());
        }

    @Test
    public void getId() throws Exception {
        assertEquals(student.getId(), 3322);
        assertEquals(0, student2.getId());
        }

    @Test
    public void toStringTest() {
        assertTrue(student.toString() != null);
        assertTrue(student2.toString().equals("Student not configured correctly"));
    }
}