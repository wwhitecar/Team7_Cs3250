package com.team7.app.controller;

import com.team7.app.business.dto.DayDto;
import com.team7.app.services.DayServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Day controller to pass information between the database
 * and html pages.
 */
@RestController
@RequestMapping(value = "/days")
public class DayController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private DayServices dayService;

    /**
     * Setter for DaysServices mapping purposes.
     * @param service - service to be used for days services
     */
    public void setDaysServices(final DayServices service) {
        this.dayService = service;
    }

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param dayName - professor teaching the days
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createDay(
            final @RequestParam ("day_name") String dayName) {
        //DayDto day = new DayDto(dayName);
        return ("Successfully created day"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }


    /**
     * Will pull information from the webpages to update a
     * day to be store into the database.
     * @param dayName - old name to be changed
     * @param changedName - new name we are chagning the day name too
     * @return state of the create request
     */
    @RequestMapping(value = "/updateday", method = RequestMethod.POST)
    public String updateDay(
            final @RequestParam ("day_name") String dayName,
            final @RequestParam ("new_day_name") String changedName) {

        DayDto day = null;
   //     for (DayDto element : dayService.listAllDays()) {
   //         if (element.getDayByName().equals(dayName)) {
   //             day = element;
   //         }
   //     }
   //     day.setDayName(changedName);

        dayService.saveDay(day);
        return ("Successfully Updated" + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }

    /**
     * Will quarry the data base to pull the specific day
     * by the day Number.
     * @param dayName - day name that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/readday", method = RequestMethod.POST)
    public String readDayByName(
            final @RequestParam("day_name") String dayName) {
        int id = 0;
        for (DayDto day : dayService.listAllDays()) {
            if (day.getDayName().equals(dayName)) {
                id = day.getDayDbKey();
            }
        }
        DayDto day = dayService.getDayByName((id));
        return day.toString();
    }

    /**
     * Delete a user that is in the database.
     * @param dayName - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/deleteday/", method = RequestMethod.GET)
    public String deleteDayByName(
            final @RequestParam("day_name") String dayName) {
        int id = 0;
   //     for (DayDto day : dayService.listAllDays()) {
  //          if (day.getDayByName().equals(dayName)) {
  //              id = day.getDayDbKey();
  //          }
  //      }

        dayService.deleteDayByName(id);
        return ("Removed Day"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }
}
