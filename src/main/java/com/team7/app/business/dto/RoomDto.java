package com.team7.app.business.dto;

import com.team7.app.services.DayServices;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private static DayServices ds;

    /**
     * A week for this room.
     */
    @OneToOne
     private WeekDto week;

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
     * Full param constructer.
     * @param rNumber - room number
     * @param rCapacity - room capacity
     * @param buildingName - name of building
     * @param roomWeek - the week for this room.
     */
    public RoomDto(final int rNumber,
                   final int rCapacity,
                   final String buildingName,
                   final WeekDto roomWeek) {
        this.week = roomWeek;
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
     * Getter for the week that is associated to this room.
     * @return  week gets returned
     */
    public WeekDto getWeek() {
        return this.week;
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
