package team7.app.business.dto;

import com.team7.app.business.dto.CourseDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDtoTest {

    private CourseDto course;
    private CourseDto course2;

    @Before
    public void before(){
        course = new CourseDto("Computer Science", 3210, 4,
                "Learn stuffs", "Be better at computer", 0000, 0000);
        course2 = new CourseDto();

    }
    @Test
    public void getDepartment() throws Exception {
        assertEquals(course.getDepartment(), "Computer Science");
        assertFalse(course.getDepartment().equals("Somthing else"));
        assertTrue(course2.getDepartment() == null);
    }

    @Test
    public void getCourseNumber() throws Exception {
        assertTrue(course.getCourseNumber() == 3210);
        assertFalse(course.getCourseNumber() == 1010);
        assertTrue(course2.getCourseNumber() == 0);
    }

    @Test
    public void getCredits() throws Exception {
        assertTrue(course.getCredits() == 4);
        assertTrue(course2.getCredits() == 0);
    }

    @Test
    public void getDescription() throws Exception {
        assertTrue(course.getDescription().equals("Learn stuffs"));
        assertTrue(course2.getDescription() == null);
    }

    @Test
    public void getLearningObjectives() throws Exception {
        assertTrue(course.getLearningObjectives()
                .equals("Be better at computer"));
        assertTrue(course2.getLearningObjectives() == null);
    }

    @Test
    public void getPrereqs() throws Exception {
        assertTrue(course2.getPrereqs() == 0000);
        assertTrue(course.getPrereqs() == 0000);
    }

    @Test
    public void getCoreqs() throws Exception {
        assertTrue(course2.getCoreqs() == 0000);
        assertTrue(course.getCoreqs() == 0000);
    }

}