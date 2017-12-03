package com.team7.app.controller;

import com.team7.app.business.dto.ScheduleDto;
import com.team7.app.business.dto.SectionDto;
import com.team7.app.business.dto.StudentDto;
import com.team7.app.services.ScheduleServices;
import com.team7.app.services.SectionServices;
import com.team7.app.services.StudentServices;
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
public class ScheduleController extends ScheduleDto {

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
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private StudentServices studentService;

    /**
     * Constent to be used instead of a magic number.
     */
    private final int eleven = 11;

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
     * Setter for scheduleServices mapping purposes.
     * @param studentServ - service to be used for building services
     */
    public void setStudentServices(final StudentServices studentServ) {
        this.studentService = studentServ;
    }

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param sectionString - professor teaching the building
     * @param studentString - students schedule
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createSchedule(
            final @RequestParam ("student_name") String studentString,
            final @RequestParam ("section") String sectionString) {
        int sectionId = parseInt(sectionString);
        int studentId = parseInt(studentString);
        SectionDto section = sectionService.getSectionById(sectionId);
        StudentDto student = studentService.getStudentById(studentId);
        if (!checkSameSectionConflict(studentId, sectionId)) {
            return ("You are already registered for this class!");
        }
        if (!checkScheduleConflict(studentId, sectionId)) {
            return ("Time conflict error!");
        }
        ScheduleDto schedule = new ScheduleDto(student, section);
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
     * Will quarry the data base to pull the specific schedule
     * by the Schedule Name.
     * @param studentName - schedule name that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/readSchedule", method = RequestMethod.POST)
    public String readScheduleByName(
            final @RequestParam("student_name") String studentName) {
        StringBuilder sb = new StringBuilder();
        sb.append("SCHEDULE INFORMATION</br>");
        int studentId = parseInt(studentName);
        int counter = 0;
        int creditCounter = 0;
        for (ScheduleDto schedule : scheduleService.listAllSchedule()) {
            if (schedule.getStudentByName().getId() == studentId) {
                counter = counter + 1;
                sb.append("Section " + counter + " </br>");
                sb.append("Section Number: "
                        + schedule.getSection().getSectionNumber()
                 + "</br>Course Information:" + "</br>Department: "
                        + schedule.getSection().getCourse().getDepartment()
                + "</br>Course Number: "
                        + schedule.getSection().getCourse().getCourseNumber()
                + "</br>Course Description: "
                        + schedule.getSection().getCourse().getDescription()
                + "</br>Learning Objective :"
                        + schedule.getSection()
                        .getCourse().getLearningObjectives()
                + "</br>Credits:"
                        + schedule.getSection().getCourse().getCredits()
                + "</br>Professor Information: </br> First Name: "
                        + schedule.getSection().getProfessor().getFirstName()
                + "</br>Last Name: "
                        + schedule.getSection().getProfessor().getLastName()
                + "</br>Time: "
                        + schedule.getSection().getDay() + " at "
                        + schedule.getSection().getTime() + " </br> </br> ");
                creditCounter = creditCounter
                        + schedule.getSection().getCourse().getCredits();
            }
        }
        sb.append("</br> Total Number of Credits this semester: "
                + creditCounter);
        return sb.toString();
    }

    /**
     * Delete a schedule that is in the database.
     * @param studentName - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/deleteSchedule/", method = RequestMethod.GET)
    public String deleteScheduleByName(
            final @RequestParam("schedules") String studentName) {
        int studentId = parseInt(studentName);
        int sectionId = parseSpecialCaseInt(studentName);
        int id = 0;
        for (ScheduleDto schedule : scheduleService.listAllSchedule()) {
            if (schedule.getStudentByName().getId() == studentId
                    && schedule.getSection().getSectionNumber() == sectionId) {
                id = schedule.getDbKey();
            }
        }

        scheduleService.deleteScheduleByName(id);
        return ("Removed Schedule"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");
    }

    /**
     * @param value to be parsed
     * @return parsed value
     *///had to change string to final for checkstyle
    public int parseInt(final String value) {
        String[] splitBySpaces = value.split(" ");
        int retVal = Integer.parseInt(splitBySpaces[2]);
        return retVal;
    }

    /**
     * @param value to be parsed
     * @return parsed value
     *///had to change string to final for checkstyle
    public int parseSpecialCaseInt(final String value) {
        String[] splitBySpaces = value.split(" ");
        int retVal = Integer.parseInt(splitBySpaces[eleven]);
        return retVal;
    }

    /**
     * @param studentId Id # of the student
     * @param sectionId Id # of the section
     * @return boolean value of whether or not there is a conflict
     *///had to change to finals for checkstyle
    public boolean checkScheduleConflict(final int studentId,
                                         final int sectionId) {
        boolean retVal = true;
        SectionDto section = sectionService.getSectionById(sectionId);
        for (ScheduleDto schedule : scheduleService.listAllSchedule()) {
            if (schedule.getStudentByName().getId() == studentId) {
                if (schedule.getSection().getDay().
                        toString().equals(section.getDay().toString())) {
                    if (schedule.getSection().getTime() == section.getTime()) {
                        retVal = false;
                        return retVal;
                    }
                }
            }
        }
        return retVal;
    }

    /**
     * @param studentId Id # of the student
     * @param sectionId Id # of the section
     * @return boolean value of whether or not there is a conflict
     *///had to change to finals for checkstyle
    public boolean checkSameSectionConflict(final int studentId,
                                             final int sectionId) {
        boolean retVal = true;
        SectionDto section = sectionService.getSectionById(sectionId);
        for (ScheduleDto schedule : scheduleService.listAllSchedule()) {
            if (schedule.getStudentByName().getId() == studentId) {
                if (schedule.getSection().getCourse().getCourseNumber()
                        == section.getCourse().getCourseNumber()) {
                    retVal = false;
                    return retVal;
                }
            }
        }
        return retVal;
    }
}
