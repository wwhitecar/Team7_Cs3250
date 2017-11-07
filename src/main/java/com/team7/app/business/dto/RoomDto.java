package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

/**
 * Room for the database to keep track of.
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
     *  Buillding the room belongs to.
     */
    private String building;

    /**
     * Capacity of room.
     */
    private int roomCapacity;

    /**
     *  many rooms have a building.
     *  @return building the room is in
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_name", nullable = false)
    public String getBuildingByName() {
        return building;
    }

    /**
     * Empty Constructer.
     */
    public RoomDto() { }

    /**
     * Full param constructer.
     * @param rNumber - room number
     * @param rCapacity - room capacity
     * @param buildingName - name of building
     */
    public RoomDto(final int rNumber,
                   final int rCapacity,
                   final String buildingName) {
        this.roomNumber = rNumber;
        this.roomCapacity = rCapacity;
        this.building = buildingName;
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
        return "Room Number: " + roomNumber + " Room Capacity" + roomCapacity;
    }
}