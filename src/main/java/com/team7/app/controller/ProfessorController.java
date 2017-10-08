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
@RequestMapping(value = "/user")
public class ProfessorController {

    private ProfessorServices professorServices;

    @Autowired
    public void setProfessorService(final ProfessorServices profService) {
        this.professorServices = profService;
    }

    /**
     * Creates a professor and puts it in the database.
     * @return String - message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ProfessorDto createProfessor(final @RequestParam("Id")int id,
                                        final @RequestParam("First Name")String firstName,
                                        final @RequestParam("Last Name")String lastName) {
        ProfessorDto professor = new ProfessorDto(firstName, lastName, id);
        return professorServices.saveProfessor(professor);
    }

    /**
     * Read a user from the database.
     * @return String with user information
     */
    @RequestMapping(value = "/professor_id")
    public String readProfessorById(final @RequestParam("Id") Integer id) {
        ProfessorDto professor = professorServices.getProfessorById(id);
        if (professor == null) {
            return "Unable to find Professor";
        }
        String string = "/";
        return professor.toString()  + "<br/> <a href="
                + string + ">Go Back to main screen</a>";
    }

    /**
     * Update a user already in the database.
     * @return String to be displayed to user after trying to update
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateProfessorById(final @RequestParam("Id")int id,
                                    final @RequestParam("First Name")String firstName,
                                    final @RequestParam("Last Name")String lastName) {
        ProfessorDto professor = new ProfessorDto(firstName, lastName, id);
        professorServices.saveProfessor(professor);
        return ("Successfully updated: <br/>" + readProfessorById(professor.getId()));
    }

    /**
     * Delete a user that is in the database.
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteProfessorById(final @RequestParam("Id") Integer id) {
        professorServices.deleteProfessor(id);
        String string = "/";
        return ("I dunno how to check....but its not in the database if it was "
                + "<br/> <a href=" + string + ">Go Back to main screen</a>");
    }
}