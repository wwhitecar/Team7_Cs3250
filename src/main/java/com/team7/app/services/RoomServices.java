package com.team7.app.services;

import com.team7.app.business.dto.RoomDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface RoomServices {
    Iterable<RoomDto> listAllRoom();

    RoomDto getRoomByNumber(Integer roomNumber);

    RoomDto saveRoom(RoomDto product);

    void deleteRoom(Integer roomNumber);
}
