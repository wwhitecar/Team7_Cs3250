package com.team7.app.business.dto;

import javax.persistence.*;
import java.util.Set;

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
     *  Buillding the room belongs to.
     */
    private BuildingDto building;

    /**
     * Capacity of room.
     */
    private int roomCapacity;

    /**
     *  many rooms have a building
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_name", nullable = false)
    private BuildingDto getBuildingByName() {
        return building;
    }

    /**
     * Empty Constructer.
     */
    public RoomDto() {}

    /**
     * Full param constructer.
     * @param rNumber - room number
     * @param rCapacity - room capacity
     */
    public RoomDto(final int rNumber,
                   final int rCapacity,
                   final BuildingDto building) {
        this.roomNumber = rNumber;
        this.roomCapacity = rCapacity;
        this.building = building;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOCK_ID", nullable = false)
    public BuildingDto getBuilding(BuildingDto building) {
        return this.building = building;
    }


    public void setBuilding(BuildingDto building) {
        this.building = building;
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
