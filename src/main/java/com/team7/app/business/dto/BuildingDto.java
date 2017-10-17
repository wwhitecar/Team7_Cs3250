package com.team7.app.business.dto;

import javax.persistence.*;
import java.util.Set;

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
    @OneToMany(mappedBy="building")
    private Set<RoomDto> rooms;

    /**
     * Empty Constructer.
     */
    public BuildingDto() {

    }

    /**
     * Param constructer.
     * @param buildingName - building name
     * @param rooms - all the rooms the building has
     */
    public BuildingDto( final String buildingName,
                       final Set rooms) {
        this.buildingName = buildingName;
        this.rooms = rooms;
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
    public Set getRooms() {
        return rooms;
    }

}