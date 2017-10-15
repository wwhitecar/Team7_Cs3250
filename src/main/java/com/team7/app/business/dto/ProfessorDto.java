package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Professors to be added to the database.
 */
@Entity
public class ProfessorDto {

    /**
     * First name of professor.
     */
    private String firstName;

    /**
     * Last name of professor.
     */
    private String lastName;

    /**
     * Id of professor.
     */
    @Id
    private int id;

    /**
     * Empty constructor.
     */
    public ProfessorDto(){}

    /**
     * Full param constructor.
     * @param fName - firts name of professor
     * @param lName - last name of professor
     * @param iD - id of professor
     */
    public ProfessorDto(final String fName,
                        final String lName, final int iD) {
        this.firstName = fName;
        this.lastName = lName;
        this.id = iD;
    }
    /**
     * Get the first name of professor.
     * @return String - first name of professor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the professor.
     * @return String - Last name of the professor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get id of the professor.
     * @return Int - the id for the professor
     */
    public int getId() {
        return id;
    }

    /**
     * Overrides the to string method.
     * @return information about the professor.
     */
    @Override
    public String toString() {
        if (firstName == null || lastName == null || id == 0) {
            return "Professor not configured correctly";
        }
        return "Name: " + firstName + " " + lastName
                + " Id: " + id;
    }
}
