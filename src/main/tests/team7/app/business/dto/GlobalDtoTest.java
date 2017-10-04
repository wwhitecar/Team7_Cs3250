package team7.app.business.dto;


import com.team7.app.business.dto.GlobalDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GlobalDtoTest {

    private GlobalDto global;
    private GlobalDto global2;

    @Before
    public void before() {
        global = new GlobalDto("School Name", 25);
        global2 = new GlobalDto();
    }


    @Test
    public void getSchoolName() throws Exception {

        assertEquals("School Name", global.getSchoolName());
        assertFalse(global.getSchoolName().equals("Not The Name"));
        assertEquals(null, global2.getSchoolName());
    }

    @Test
    public void getCreditHours() throws Exception {
        assertTrue(global.getLevelByHour() == 25);
        assertFalse(global.getLevelByHour() == 52);
        assertTrue(global2.getLevelByHour() == 0);

    }
}
