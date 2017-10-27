package com.team7.app.services;

import com.team7.app.business.dto.BuildingDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface BuildingServices {

    /**
     * Creates a list of all buildings that are currently in the
     * database.
     * @return list of all buildings in the database
     */
    Iterable<BuildingDto> listAllBuilding();

    /**
     * Finds a building that resides in the database.
     * @param id - id number for the building we are looking for.
     * @return the building that we are looking for
     */
    BuildingDto getBuildingByName(int id);

    /**
     * Adds a building to the database.
     * @param building - to be added.
     * @return the building that was added to the database.
     */
    BuildingDto saveBuilding(BuildingDto building);

    /**
     * Delete a building that is in the database.
     * @param id - buildings id to be removed
     */
    void deleteBuildingByName(int id);
}
