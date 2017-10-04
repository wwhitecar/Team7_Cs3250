package com.team7.app.business.dto;

/**
 * Professors to be added to the database.
 */
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
    private int id;

    /**
     * Empty Constructer.
     */
    public ProfessorDto() {

    }

    /**
     * Full param constructer.
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
}
