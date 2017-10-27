package com.team7.app.business.dto;

import com.team7.app.business.dto.RoomDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomDtoTest {

    private RoomDto room;
    private RoomDto room2;

    @Before
    public void before() {
        room = new RoomDto(1011, 45, "North");
        room2 = new RoomDto();
    }

    @Test
    public void getRoomNumber() throws Exception {
        assertEquals(room.getRoomNumber(), 1011);
        assertFalse(room.getRoomNumber() == -11);
        assertTrue(room2.getRoomNumber() == 0);
    }

    @Test
    public void getRoomCapacity() throws Exception {
        assertEquals(room.getRoomCapacity(), 45);
        assertFalse(room.getRoomCapacity() == 0);
        assertTrue(room2.getRoomCapacity() == 0);
    }

    @Test
    public void getBuildingByName() throws Exception {
        assertTrue(room.getBuildingByName().equals("North"));
        assertFalse(room.getBuildingByName().equals("South"));
       // assertTrue(room2.getBuildingByName().equals(null));
    }
}