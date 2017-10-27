package com.team7.app.services;

import com.team7.app.business.dto.RoomDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface RoomServices {

    /**
     * Creates a list of all rooms that are currently in the
     * database.
     * @return list of all rooms in the database
     */
    Iterable<RoomDto> listAllRoom();

    /**
     * Finds a room that resides in the database.
     * @param roomNumber - id for the room we are looking for.
     * @return the room that we are looking for
     */
    RoomDto getRoomByNumber(Integer roomNumber);

    /**
     * Adds a room to the database.
     * @param room to be added.
     * @return the room that was added to the database.
     */
    RoomDto saveRoom(RoomDto room);

    /**
     * Delete a room that is in the database.
     * @param roomNumber of the room to be removed
     */
    void deleteRoom(Integer roomNumber);
}
