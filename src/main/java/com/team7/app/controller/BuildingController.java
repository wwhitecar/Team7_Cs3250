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
    @Autowired
    protected BuildingServices buildingServices;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    protected RoomServices roomServices;

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
        building = buildingServices.saveBuilding(building);
        if (building != null) {
            return "Successfully created Building"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>";
        }
        return ("Unable to create Builing" + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
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
        building = buildingServices.saveBuilding(building);
        if (building != null){
            return ("Unable to add Building" + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return ("Successfully Added" + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }

    /**
     * Will quarry the data base to pull the specific building
     * by the Building Number.
     * @param buildingName - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/readbuilding", method = RequestMethod.GET)
    public String readBuildingByName(
            final @RequestParam("building_name") String buildingName) {
        BuildingDto building = buildingServices.getBuildingByName((buildingName));
        if (building != null) {
            return building.toString();
        }
        return "Unable to find Building";
    }

    /**
     * Delete a user that is in the database.
     * @param buildingName - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/deletebuilding/", method = RequestMethod.GET)
    public String deleteBuildingByName(final @RequestParam("building_name") String buildingName) {
        buildingServices.deleteBuildingByName(buildingName);
        if (readBuildingByName(buildingName).equals("Unable to find Building")) {
            return ("Removed Building"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return "Unable to find student, plz try again";
    }
}