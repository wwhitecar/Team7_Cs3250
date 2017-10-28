package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Buildings that will be stored into the
 * database.
 */
@Entity
public class ScheduleDto {

    /**
     * Id for the database that is auto generated
     * to assure no duplicates are created.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbKey;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    private String buildingName;
//
//    @OneToMany
//    private Set<RoomDto> Rooms = new HashSet<RoomDto>(0);
//
//    /**
//     * The course number to identify a course by more then
//     * just the name.
//     */
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building_name")
//    @Column(name = "building_name", unique = true, nullable = false)
//    public Set<RoomDto> getBuildingRooms() {
//        return this.Rooms;
//    }
//
//    public void setBuildingRooms(Set<RoomDto> Rooms) {
//        this.Rooms = Rooms;
//    }

    /**
     * Empty Constructer.
     */
    public ScheduleDto() {

    }

    /**
     * Param constructer.
     * @param nameOfBuilding - building name
     */
    public ScheduleDto(final String nameOfBuilding) {
        this.buildingName = nameOfBuilding;
    }

    /**
     * Getter for buildingName.
     * @return name of the building.
     */
    public String getBuildingByName() {
        return buildingName;
    }

    /**
     * Setter for buildingName.
     * @param buildName - the new building name
     */
    public void setBuildingName(final String buildName) {
        this.buildingName = buildName;
    }

    /**
     * Getter for dBKey.
     * @return id of the building
     */
    public int getDbKey() {
        return dbKey;
    }

}


