package com.team7.app.services;

import com.team7.app.business.dto.BuildingDto;
import com.team7.app.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServicesImpl implements BuildingServices {

    private BuildingRepository buildingRepository;

    @Autowired
    public void setBuildingRepository(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }
    @Override
    public Iterable<BuildingDto> listAllBuilding() {
        return buildingRepository.findAll();
    }

    @Override
    public BuildingDto getBuildingByName(String name) {
        return buildingRepository.findOne(name);
    }

    @Override
    public BuildingDto saveBuilding(BuildingDto building) {
        return buildingRepository.save(building);
    }

    @Override
    public void deleteBuildingByName(String name) {
        buildingRepository.delete(name);
    }
}
