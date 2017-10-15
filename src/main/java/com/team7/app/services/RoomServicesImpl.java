package com.team7.app.services;

import com.team7.app.business.dto.RoomDto;
import com.team7.app.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class RoomServicesImpl implements RoomServices {
    private RoomRepository roomRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Iterable<RoomDto> listAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public RoomDto getRoomByNumber(Integer roomNumber) {
        return roomRepository.findOne(roomNumber);
    }

    @Override
    public RoomDto saveRoom(RoomDto room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Integer roomNumber) {
        roomRepository.delete(roomNumber);
    }
}