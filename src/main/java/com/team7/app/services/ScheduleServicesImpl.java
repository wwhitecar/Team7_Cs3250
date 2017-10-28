package com.team7.app.services;

import com.team7.app.business.dto.BuildingDto;
import com.team7.app.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class ScheduleServicesImpl implements BuildingServices {

    /**
     * Building repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    @Autowired
    private BuildingRepository buildingRepository;

    /**
     * Setter for BuildingRepository, used for testing purposes
     * only.
     * @param buildingRepo - buildingRepo to be used for testing
     */
    public void setBuildingRepository(final BuildingRepository buildingRepo) {
        this.buildingRepository = buildingRepo;
    }

    /**
     * Creates a list of all buildings that are currently in the
     * database.
     * @return list of all buildings in the database
     */
    @Override
    public Iterable<BuildingDto> listAllBuilding() {
        return buildingRepository.findAll();
    }

    /**
     * Finds a building that resides in the database.
     * @param id - id number for the building we are looking for.
     * @return the building that we are looking for
     */
    @Override
    public BuildingDto getBuildingByName(final int id) {
        return buildingRepository.findOne(id);
    }

    /**
     * Adds a building to the database.
     * @param building - to be added.
     * @return the building that was added to the database.
     */
    @Override
    public BuildingDto saveBuilding(final BuildingDto building) {
        return buildingRepository.save(building);
    }

    /**
     * Delete a building that is in the database.
     * @param id - buildings id to be removed
     */
    @Override
    public void deleteBuildingByName(final int id) {
        buildingRepository.delete(id);
    }
}
