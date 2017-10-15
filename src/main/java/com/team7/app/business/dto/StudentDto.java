package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User for the database to keep track of.
 * Entity tag is for adding something to the database.
 */
@Entity
public class StudentDto {

    /**
     * First name of user.
     */
    private String firstName;

    /**
     * Last name of user.
     */
    private String lastName;

    /**
     * Id of user, also the primary key for the database.
     */
    @Id
    private int id;

    /**
     * Empty Constructer.
     */
    public StudentDto() {

    }

    /**
     * Full param constructer.
     * @param fName - firts name of user
     * @param lName - last name of user
     * @param iD - id of user
     */
    public StudentDto(final String fName,
                      final String lName, final int iD) {
        this.firstName = fName;
        this.lastName = lName;
        this.id = iD;
    }
    /**
     * Get the first name of user.
     * @return String - first name of user
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * Gets the last name of the user.
     * @return String - Last name of the user
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * Get id of the user.
     * @return Int - the id for the user
     */
    public int getId() {

        return id;
    }

    /**
     * Overrides the to string method.
     * @return information about the student.
     */
    @Override
    public String toString() {
        if (firstName == null || lastName == null || id == 0) {
            return "Student not configured correctly";
        }
        return "Name: " + firstName + " " + lastName
                + " Id: " + id;
    }
}
