package team7.app.business.dto;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.business.dto.SectionDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SectionDtoTest {

    SectionDto sectionOne;
    SectionDto sectionTwo;
    CourseDto course;
    ProfessorDto professor;

    @Before
    public void before(){
        course = new CourseDto("Computer Science", 3210, 4,
                "Learn stuffs", "Be better at computer", 0000, 0000);
        professor = new ProfessorDto("Donald", "Trump", 123);
        sectionOne = new SectionDto();
        sectionTwo = new SectionDto(123, course, professor);
    }

    @Test
    public void getSectionNumberTest() throws Exception {
        assertTrue(sectionOne.getSectionNumber() == 0);
        assertTrue(sectionTwo.getSectionNumber() == 123);
    }

    @Test
    public void getCourseTest() throws Exception {
        assertEquals(course, sectionTwo.getCourse());
        assertEquals(null, sectionOne.getCourse());
    }

    @Test
    public void getProfessorTest() throws Exception {
        assertEquals(professor, sectionTwo.getProfessor());
        assertEquals(null, sectionOne.getCourse());
    }

    @Test
    public void toStringTest() throws Exception {
        String answer = sectionTwo.toString();
        assertTrue(answer != "");
    }

}