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
public class DaysDto {

    /**
     * Id for the database that is auto generated
     * to assure no duplicates are created.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DaysDbKey;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    private String dayName;

    /**
     * Empty Constructer.
     */
    public DaysDto() { }

    /**
     * Param constructer.
     * @param dayOfTheWeek - building name
     */
    public DaysDto(final String dayOfTheWeek) {
        this.dayName = dayOfTheWeek;
    }

    /**
     * Getter for buildingName.
     * @return name of the building.
     */
    public String getDayByName() {
        return dayName;
    }

    /**
     * Setter for buildingName.
     * @param dayOfTheWeek - the new building name
     */
    public void setDayByName(final String dayOfTheWeek) {
        this.dayName = dayOfTheWeek
    }

    /**
     * Getter for dBKey.
     * @return id of the building
     */
    public int getDayDbKey() {
        return DaysDbKey;
    }

}


