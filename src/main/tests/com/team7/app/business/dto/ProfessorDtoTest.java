package com.team7.app.business.dto;

import com.team7.app.business.dto.ProfessorDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorDtoTest {

    private ProfessorDto professor;
    private ProfessorDto professor2;

    @Before
    public void Before() {
        professor = new ProfessorDto("Donald", "Trump", 123);
        professor2 = new ProfessorDto();
    }

    @Test
    public void getFirstNameTest() throws Exception {
        assertEquals(professor.getFirstName(), "Donald");
        assertFalse(professor.getFirstName().equals("Barack"));
        assertTrue(professor2.getFirstName() == null);
    }

    @Test
    public void getLastNameTest() throws Exception {
        assertEquals(professor.getLastName(), "Trump");
        assertFalse(professor.getLastName().equals("Obama"));
        assertTrue(professor2.getLastName() == null);
    }

    @Test
    public void getIdTest() throws Exception {
        assertEquals(professor.getId(), 123);
        assertFalse(professor.getId() == 23);
        assertTrue(professor2.getId() == 0);
    }

    @Test
    public void toStringTest(){
        assertTrue(professor2.toString().equals("Professor not configured correctly"));
    }
}