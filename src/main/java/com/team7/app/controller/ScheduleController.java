package com.team7.app.controller;

import com.team7.app.business.dto.BuildingDto;
import com.team7.app.services.BuildingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Building controller to pass information between the database
 * and html pages.
 */
@RestController
@RequestMapping(value = "/building")
public class ScheduleController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private BuildingServices buildingService;

    /**
     * Setter for buildingServices mapping purposes.
     * @param service - service to be used for building services
     */
    public void setBuildingServices(final BuildingServices service) {
        this.buildingService = service;
    }

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param buildingName - professor teaching the building
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createBuilding(
            final @RequestParam ("building_name") String buildingName) {
        BuildingDto building = new BuildingDto(buildingName);
        building = buildingService.saveBuilding(building);
        if (building != null) {
            return ("Successfully created Building"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return ("Unable to create Builing" + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }


    /**
     * Will pull information from the webpages to update a
     * building to be store into the database.
     * @param buildingName - old name to be changed
     * @param changedName - new name we are chagning the building name too
     * @return state of the create request
     */
    @RequestMapping(value = "/updatebuilding", method = RequestMethod.POST)
    public String updateBuilding(
            final @RequestParam ("building_name") String buildingName,
            final @RequestParam ("new_building_name") String changedName) {

        BuildingDto building = null;
        for (BuildingDto element : buildingService.listAllBuilding()) {
            if (element.getBuildingByName().equals(buildingName)) {
                building = element;
            }
        }
        building.setBuildingName(changedName);

        building = buildingService.saveBuilding(building);
        return ("Successfully Updated" + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }

    /**
     * Will quarry the data base to pull the specific building
     * by the Building Number.
     * @param buildingName - building name that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/readbuilding", method = RequestMethod.POST)
    public String readBuildingByName(
            final @RequestParam("building_name") String buildingName) {
        int id = 0;
        for (BuildingDto building : buildingService.listAllBuilding()) {
            if (building.getBuildingByName().equals(buildingName)) {
                id = building.getDbKey();
            }
        }
        BuildingDto building = buildingService.getBuildingByName((id));
        return building.toString();
    }

    /**
     * Delete a user that is in the database.
     * @param buildingName - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/deletebuilding/", method = RequestMethod.GET)
    public String deleteBuildingByName(
            final @RequestParam("building_name") String buildingName) {
        int id = 0;
        for (BuildingDto building : buildingService.listAllBuilding()) {
            if (building.getBuildingByName().equals(buildingName)) {
                id = building.getDbKey();
            }
        }

        buildingService.deleteBuildingByName(id);
        return ("Removed Building"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }
}
