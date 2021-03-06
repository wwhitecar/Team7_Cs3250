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
public class BuildingDto {

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

    /**
     * Empty Constructer.
     */
    public BuildingDto() { }

    /**
     * Param constructer.
     * @param nameOfBuilding - building name
     */
    public BuildingDto(final String nameOfBuilding) {
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


