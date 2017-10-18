package com.team7.app.business.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BuildingDto {

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @Id
    private String buildingName;

    private Set<RoomDto> Rooms = new HashSet<RoomDto>(0);

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    public Set<RoomDto> getBuildingRooms() {
        return this.Rooms;
    }

    public void setBuildingRooms(Set<RoomDto> Rooms) {
        this.Rooms = Rooms;
    }

    /**
     * Empty Constructer.
     */
    public BuildingDto() {

    }

    /**
     * Param constructer.
     *
     * @param buildingName - building name
     */
    public BuildingDto(final String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * Getter for buildingName.
     *
     * @return name of the building.
     */
    public String getBuildingName() {
        return buildingName;
    }

}


