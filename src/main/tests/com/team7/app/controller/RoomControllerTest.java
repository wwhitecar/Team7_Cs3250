package com.team7.app.controller;

import com.team7.app.business.dto.RoomDto;
import com.team7.app.services.RoomServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoomControllerTest {

    @Mock
    RoomServicesImpl roomMock;

    RoomController roomController;

    RoomDto room;

    @Before
    public void before() {
        roomController = new RoomController();
        roomController.setRoomService(roomMock);
        room = new RoomDto(1001, 41, "Science");
    }

    @Test
    public void createRoomTest() throws Exception {
        assertEquals(roomController.createRoom(1001, 41, "Science"),
                "Error adding Room for some reason");
        when(roomMock.saveRoom(anyObject())).thenReturn(room);
       assertEquals(roomController.createRoom(1001, 41, "Science"), room.toString()  + " Added Successfully <br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    @Test
    public void readRoomByNumberTest() throws Exception {
        assertEquals(roomController.readRoomByNumber(1001), "Unable to find Room");
        when(roomMock.getRoomByNumber(anyInt())).thenReturn(room);
        assertEquals(roomController.readRoomByNumber(1001), room.toString()  + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>" );
    }

    @Test
    public void updateRoomByNumberTest() throws Exception {
        assertEquals(roomController.updateRoomByNumber(1001, 41, "Science"), "Unable to find Room");
        when(roomMock.saveRoom(anyObject())).thenReturn(room);
        assertEquals(roomController.updateRoomByNumber(1001, 41, "Science"), "Successfully updated: <br/>Unable to find Room");
    }

    @Test
    public void deleteRoomByNumberTest() throws Exception {
        assertEquals(roomController.deleteRoomByNumber(1001), "Removed Room"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }


}