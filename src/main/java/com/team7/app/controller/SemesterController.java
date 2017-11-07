package com.team7.app.controller;

import com.team7.app.business.dto.SemesterDto;
import com.team7.app.services.SemesterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlles communication between the webpages and the database
 * for the semester class.
 */
@RestController
@RequestMapping(value = "/semester")
public class SemesterController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private SemesterServices semesterService;

    /**
     * Setter for ProfessorService, for testing purposes only.
     * @param semesterServ - service to be used
     */
    public void setSemesterService(final SemesterServices semesterServ) {
        this.semesterService = semesterServ;
    }

    /**
     * Creates a new semester that has a name.
     * @param semesterName - the name of the semester
     * @return the status of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createSemester(
            final @RequestParam("semesterName") String semesterName) {
        SemesterDto semester = new SemesterDto(semesterName);
        semesterService.saveSemester(semester);
        return "Successfully created semester <br/> <a href="
                                    + "/" + ">Go Back to main screen</a>";
    }

    /**
     * Update an existing semester in the database.
     * @param currentName - the name of the current semester
     * @param newName - new name for the semester
     * @return the status of the update request
     */
    @RequestMapping(value = "/updateSemester", method = RequestMethod.POST)
    public String updateSemester(
            final @RequestParam("currentName") String currentName,
            final @RequestParam("newName") String newName) {
        SemesterDto semester = null;
        for (SemesterDto sem: semesterService.listAllSemesters()) {
            if (sem.getSemesterName().equals(currentName)) {
                semester = sem;
            }
        }
        semester.setSemesterName(newName);
        semesterService.saveSemester(semester);
        return ("Successfully updated semester <br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    /**
     * Read a semester from the database and display information.
     * @param semesterName - the name of the semester we are reading
     * @return information pertaining to the semester we are interested in.
     */
    @RequestMapping(value = "/getSemester", method = RequestMethod.GET)
    public String readSemester(
            final @RequestParam("semesterName") String semesterName) {
        SemesterDto semester = null;
        for (SemesterDto sem: semesterService.listAllSemesters()) {
            if (sem.getSemesterName().equals(semesterName)) {
                semester = sem;
            }
        }
        return semester.getSemesterName() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>";
    }

    /**
     * Delete a semester form the database.
     * @param semesterName - the name of the semester to be deleted
     */
    @RequestMapping (value = "/deleteSemester", method = RequestMethod.GET)
    public void deleteSemester(
            final @RequestParam("semesterName") String semesterName) {
        SemesterDto semester = null;
        for (SemesterDto sem: semesterService.listAllSemesters()) {
            if (sem.getSemesterName().equals(semesterName)) {
                semester = sem;
            }
        }

        semesterService.deleteSemesterById(semester.getDbKey());
    }
}
