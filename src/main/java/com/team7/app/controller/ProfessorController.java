package com.team7.app.controller;

import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.services.ProfessorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class that will communicate with both the webapplication
 * and the data base to transfer information.
 */

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private ProfessorServices professorService;

    /**
     * Setter for Professor Service for testing purposes.
     * @param profService - mock to be used
     */
    public void setProfessorService(final ProfessorServices profService) {
        this.professorService = profService;
    }

    /**
     * Creates a professor and puts it in the database.
     * @param id - id of the professor.
     * @param firstName - first name of the professor.
     * @param lastName - last name of the professor.
     * @return message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createProfessor(final @RequestParam("Id")int id,
                         final @RequestParam("First Name")String firstName,
                         final @RequestParam("Last Name")String lastName) {
        ProfessorDto professor = new ProfessorDto(firstName, lastName, id);
        professorService.saveProfessor(professor);
        return (professor.toString()  + " Added Successfully <br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    /**
     * Read a user from the database.
     * @param id - id of hte professor to be found in database
     * @return information about the professor found
     */
    @RequestMapping(value = "/professor_id")
    public String readProfessorById(final @RequestParam("Id") Integer id) {
        ProfessorDto professor = professorService.getProfessorById(id);
        if (professor == null) {
            return "Unable to find Professor";
        }
        return professor.toString()  + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>";
    }

    /**
     * Update a user already in the database.
     * @param id - id of the professor.
     * @param firstName - first name of the professor
     * @param lastName - the last name of hte professor.
     * @return String to be displayed to user after trying to update
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateProfessorById(final @RequestParam("Id")int id,
                              final @RequestParam("First Name")String firstName,
                              final @RequestParam("Last Name")String lastName) {
        ProfessorDto professor = new ProfessorDto(firstName, lastName, id);
        professorService.saveProfessor(professor);
        return ("Successfully updated: <br/>"
                + readProfessorById(professor.getId()));
    }

    /**
     * Delete a user that is in the database.
     * @param id - id to find and remove the professor from database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteProfessorById(final @RequestParam("Id") Integer id) {
        professorService.deleteProfessor(id);
        return ("Removed Professor"
                  + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");

    }
}
