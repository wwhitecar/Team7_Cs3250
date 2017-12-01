package com.team7.app.controller;

import com.team7.app.business.dto.DayDto;
import com.team7.app.business.dto.RoomDto;
import com.team7.app.business.dto.WeekDto;
import com.team7.app.services.DayServicesImpl;
import com.team7.app.services.RoomServicesImpl;
import com.team7.app.services.WeekServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RoomControllerTest {

    @Mock
    RoomServicesImpl roomMock;

    @Mock
    DayServicesImpl dayMock;

    @Mock
    WeekServicesImpl weekMock;

    RoomController roomController;

    RoomDto room;

    @Before
    public void before() {
        roomController = new RoomController();
        roomController.setRoomService(roomMock);
        roomController.setDayService(dayMock);
        roomController.setWeekService(weekMock);

        List<DayDto> listy = new ArrayList<>();
        listy.add(new DayDto("monday"));
        listy.add(new DayDto("tuesday"));
        listy.add(new DayDto("wednesday"));
        listy.add(new DayDto("thursday"));
        listy.add(new DayDto("friday"));
        listy.add(new DayDto("saturday"));
        listy.add(new DayDto("sunday"));

        room = new RoomDto(1001, 41, "Science", new WeekDto(listy));
    }

    @Test
    public void createRoomTest() throws Exception {
        when(roomMock.saveRoom(anyObject())).thenReturn(room);
        when(dayMock.saveDay(anyObject())).thenReturn(new DayDto());
        when(weekMock.saveWeek(anyObject())).thenReturn(new WeekDto());
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
        when(roomMock.getRoomByNumber(anyInt())).thenReturn(room);
        room.getWeek().setWeekDbkey(1);
        assertEquals(roomController.deleteRoomByNumber(1001), "Removed Room"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }


}