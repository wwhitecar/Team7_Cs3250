package com.team7.app.services;

import com.team7.app.business.dto.RoomDto;
import com.team7.app.repositories.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoomServicesImplTest {

    @Mock
    RoomRepository rRepo;
    RoomServicesImpl roomServ;

    @Before
    public void before() {
        roomServ = new RoomServicesImpl();
        roomServ.setRoomRepository(rRepo);

    }

    @Test
    public void listAllRoom() {
        Iterable<RoomDto> roomList = new ArrayList<>();
        when(rRepo.findAll()).thenReturn(roomList);
        assertNotNull(roomServ.listAllRoom());
    }

    @Test
    public void getRoomByNumberTest() {
        RoomDto room = new RoomDto();
        when(rRepo.findOne(anyInt())).thenReturn(room);
        assertNotNull(roomServ.getRoomByNumber(1010));

    }

    @Test
    public void saveRoomTest() {
        RoomDto room = new RoomDto();
        when(rRepo.save(room)).thenReturn(room);
        assertNotNull(roomServ.saveRoom(room));
    }

    @Test
    public void deleteRoomTest() {roomServ.deleteRoom(1010);}
}