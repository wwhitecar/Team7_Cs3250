package com.team7.app.services;

import com.team7.app.business.dto.BuildingDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface BuildingServices {

    Iterable<BuildingDto> listAllBuilding();

    BuildingDto getBuildingByName(Integer name);

    BuildingDto saveBuilding(BuildingDto product);

    void deleteBuilding(Integer id);
}