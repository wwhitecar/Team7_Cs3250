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
    private String scheduleName;
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
     * @param nameOfSchedule - building name
     */
    public ScheduleDto(final String nameOfSchedule) {
        this.scheduleName = nameOfSchedule;
    }

    /**
     * Getter for ScheduleName.
     * @return name of the Schedule.
     */
    public String getScheduleByName() {
        return scheduleName;
    }

    /**
     * Setter for buildingName.
     * @param scheduleName - the new schedule name
     */
    public void setScheduleName(final String scheduleName) {
        this.scheduleName = scheduleName;
    }

    /**
     * Getter for dBKey.
     * @return id of the schedule
     */
    public int getDbKey() {
        return dbKey;
    }

}


