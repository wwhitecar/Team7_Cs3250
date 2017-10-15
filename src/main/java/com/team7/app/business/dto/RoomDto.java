package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User for the database to keep track of.
 * Entity tag is for adding something to the database.
 */
@Entity
public class RoomDto {

    /**
     * room number.
     */
    @Id
    private int roomNumber;

    /**
     * Capacity of room.
     */
    private int roomCapacity;

    /**
     * Empty Constructer.
     */
    public RoomDto() {

    }

    /**
     * Full param constructer.
     * @param rNumber - room number
     * @param rCapacity - room capacity
     */
    public RoomDto(final int rNumber,
                      final int rCapacity) {
        this.roomNumber = rNumber;
        this.roomCapacity = rCapacity;
    }
    /**
     * Get the number of the room.
     * @return int - number of the room
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Gets the room capacity.
     * @return int - room capacity
     */
    public int getRoomCapacity() {
        return roomCapacity;
    }


    /**
     * Overrides the to string method.
     * @return information about the student.
     */
    @Override
    public String toString() {
        if (roomNumber == 0 || roomCapacity == 0) {
            return "room not set up correctly";
        }
        return "Room Number: " + roomNumber + " Room Capacity" + roomCapacity;
    }
}
