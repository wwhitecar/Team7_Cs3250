package com.team7.app.business.dto;

import javax.persistence.*;

@Entity
public class BuildingDto {

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @Id
    private String buildingName;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @ManyToOne
    private RoomDto room;

    /**
     * Empty Constructer.
     */
    public BuildingDto() {

    }

    /**
     * Param constructer.
     * @param buildingName - course to be tied to this building
     * @param room - professor of the class/building
     */
    public BuildingDto( final String buildingName,
                       final RoomDto room) {
        this.buildingName = buildingName;
        this.room = room;
    }

    /**
     * Getter for buildingName.
     * @return name of the building.
     */
    public String getBuildingName() {
        return buildingName;
    }


    /**
     * Getter for coursenumber.
     * @return number for the course.
     */
    public RoomDto getRoomNumber() {
        return room;
    }

}