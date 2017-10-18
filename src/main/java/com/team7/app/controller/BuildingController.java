package com.team7.app.controller;

import com.team7.app.business.dto.RoomDto;
import com.team7.app.business.dto.BuildingDto;
import com.team7.app.services.BuildingServices;
import com.team7.app.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/building")
public class BuildingController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    private BuildingServices buildingServices;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    private RoomServices roomServices;

    /**
     * Bean to be used throughout the professor class.
     * @param rServices - bean to be created
     */
    @Autowired
    public void setRoomService(final RoomServices rServices) {
        this.roomServices = rServices;
    }

    /**
     * Bean to be used throughout the course controller class.
     * @param bServices - bean to be created
     */
    @Autowired
    public void setBuildingServices(final BuildingServices bServices) {
        this.buildingServices = bServices;
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
        buildingServices.saveBuilding(building);
        return ("Success");
    }


    /**
     * Will pull information from the webpages to update a
     * building to be store into the database.
     * @param buildingName - course specific number
     * @return state of the create request
     */
    @RequestMapping(value = "/updatebuilding", method = RequestMethod.POST)
    public String updateBuilding(
            final @RequestParam ("building_name") String buildingName){
        BuildingDto building = new BuildingDto(buildingName);
        buildingServices.saveBuilding(building);
        return ("Success");
    }

    /**
     * Will quarry the data base to pull the specific building
     * by the Building Number.
     * @param buildingName - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/getbuilding", method = RequestMethod.GET)
    public String readBuildingByName(
            final @RequestParam("building_name") String buildingName) {
        return "";
    }

    /**
     * Delete a user that is in the database.
     * @param buildingName - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteBuildingByName(final @RequestParam("room number") String buildingName) {
        buildingServices.deleteBuildingByName(buildingName);
        if (readBuildingByName(buildingName).equals("Unable to find Building")) {
            return ("Removed Room"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return "Unable to find student, plz try again";
    }
}