package com.team7.app.controller;

import com.team7.app.business.dto.GlobalDto;
import com.team7.app.services.GlobalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Global class controller to talk to the database.
 */
@RequestMapping(value = "/global")
@RestController
public class GlobalController {


    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private GlobalServices globalServices;

    /**
     * Mapping to create a new global value in database.
     * @param schoolName - name of the school
     * @param creditHours - credit hours.
     * @return status of the request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public  String createGlobal(
            final @RequestParam("school_name") String schoolName,
            final @RequestParam("credit_Hour") int creditHours)  { //change var

        GlobalDto global = new GlobalDto(schoolName, creditHours);
        globalServices.saveGlobal(global);
        if(!readGlobalByName(schoolName).equals("Unable to find School")) {
            return (global + "Added Successfully <br/> <a href=" + "/" + ">Go Back to main screen</a>");
        }
        return ("Success");
    }

    /**
     * Reads the global values and displays them from the database.
     * @param name - school name to get the information for.
     * @return information about the school.
     */
    @RequestMapping(value = "/getglobal", method = RequestMethod.GET)
    public String readGlobalByName(
            final @RequestParam("School Name") String name) {
        GlobalDto global = globalServices.getGlobalByName(name);
        if (global == null) {
            return "Unable to find Course";
        }
        return (global + " <br/> <a href=" + "/" + ">Go Back to main screen</a>");
    }

    /**
     * Mapping for update to change the global values in database.
     * @param schoolName - new name of the school.
     * @param creditHours - new credits hours for school
     * @return status of the request
     */
    @RequestMapping(value = "/updateglobal", method = RequestMethod.GET)
    public String updateGlobalByName(
            final @RequestParam("School Name") String schoolName,
            final @RequestParam("credit_Hour") int creditHours) {
        GlobalDto global = new GlobalDto(schoolName, creditHours);
        globalServices.saveGlobal(global);
        if (!readGlobalByName(schoolName).equals("Unable to find school")) {
            return (global + " Added Successfully <br/> <a href=" + "/" + ">Go Back to main screen</a>");
        }
        return ("Unable to find school");
    }

    /**
     * Mapping to delete the global for the database.
     * @param schoolName - name of the school
     * @return status of the request
     */
    @RequestMapping(value = "/deleteglobal", method = RequestMethod.GET)
    public String deleteGlobalByName(
            final @RequestParam("School Name") String schoolName) {
        globalServices.deleteGlobal(schoolName);
        if(readGlobalByName(schoolName).equals("Unable to find School")) {
            return ("Removed School" + "<br/> <a href=" + "/" + ">Go Back to main screen<a/>");
        }
        return ("Unable to remove school, please try again" + "<br/> <a href=" + "/" + ">Go Back to main screen</a>");
    }

}
