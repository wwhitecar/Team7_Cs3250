package com.team7.app.controller;

import com.team7.app.business.dto.ScheduleDto;
import com.team7.app.business.dto.SectionDto;
import com.team7.app.services.ScheduleServices;
import com.team7.app.services.SectionServices;
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
@RequestMapping(value = "/schedule")
public class ScheduleController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private ScheduleServices scheduleService;

    /**
     * Services to be used by hibernate to correctly add/remove
     * information to the database.
     */
    @Autowired
    private SectionServices sectionService;

    /**
     * Setter for SectionService, for testing purposes only.
     * @param sectionServ - service to be used
     */
    public void setSectionService(final SectionServices sectionServ) {
        this.sectionService = sectionServ;
    }

    /**
     * Setter for scheduleServices mapping purposes.
     * @param service - service to be used for building services
     */
    public void setScheduleServices(final ScheduleServices service) {
        this.scheduleService = service;
    }

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param scheduleName - professor teaching the building
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createSchedule(
            final @RequestParam ("schedule_name") String scheduleName,
            final @RequestParam ("section") int sectionId) {
        SectionDto section = sectionService.getSectionById(sectionId);
        ScheduleDto schedule = new ScheduleDto(scheduleName,section);
        schedule = scheduleService.saveSchedule(schedule);
        if (schedule != null) {
            return ("Successfully created Schedule"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return ("Unable to create Schedule" + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }


    /**
     * Will pull information from the webpages to update a
     * Schedule to be store into the database.
     * @param scheduleName - old name to be changed
     * @param changedName - new name we are chagning the schedule name too
     * @return state of the create request
     */
    @RequestMapping(value = "/updateSchedule", method = RequestMethod.POST)
    public String updateSchedule(
            final @RequestParam ("schedule_name") String scheduleName,
            final @RequestParam ("new_schedule_name") String changedName) {

        ScheduleDto schedule = null;
        for (ScheduleDto element : scheduleService.listAllSchedule()) {
            if (element.getScheduleByName().equals(scheduleName)) {
                schedule = element;
            }
        }

        return ("Successfully Updated" + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }

    /**
     * Will quarry the data base to pull the specific schedule
     * by the Schedule Name.
     * @param scheduleName - schedule name that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/readSchedule", method = RequestMethod.POST)
    public String readScheduleByName(
            final @RequestParam("schedule_name") String scheduleName) {
        int id = 0;
        return "";
    }

    /**
     * Delete a schedule that is in the database.
     * @param scheduleName - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/deleteSchedule/", method = RequestMethod.GET)
    public String deleteScheduleByName(
            final @RequestParam("schedule_name") String scheduleName) {
        int id = 0;
        return ("Removed Building"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }
}
