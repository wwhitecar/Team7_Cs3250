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

    /**
     * Room Repo to allow communcation to the database.
     */
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Setter for room Repository for testint purposes.
     * @param roomRepo - mock of the repo
     */
    public void setRoomRepository(final RoomRepository roomRepo) {
        this.roomRepository = roomRepo;
    }

    /**
     * Creates a list of all rooms that are currently in the
     * database.
     * @return list of all rooms in the database
     */
    @Override
    public Iterable<RoomDto> listAllRoom() {
        return roomRepository.findAll();
    }

    /**
     * Finds a room that resides in the database.
     * @param roomNumber - id for the room we are looking for.
     * @return the room that we are looking for
     */
    @Override
    public RoomDto getRoomByNumber(final Integer roomNumber) {
        return roomRepository.findOne(roomNumber);
    }

    /**
     * Adds a room to the database.
     * @param room to be added.
     * @return the room that was added to the database.
     */
    @Override
    public RoomDto saveRoom(final RoomDto room) {
        return roomRepository.save(room);
    }

    /**
     * Delete a room that is in the database.
     * @param roomNumber of the room to be removed
     */
    @Override
    public void deleteRoom(final Integer roomNumber) {
        roomRepository.delete(roomNumber);
    }
}
