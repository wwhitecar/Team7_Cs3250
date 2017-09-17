package com.team7.app.business.dto;

/**
 * User for the database to keep track of.
 */
public class UserDto {

    /**
     * First name of user.
     */
    private String firstName;

    /**
     * Last name of user.
     */
    private String lastName;

    /**
     * Id of user.
     */
    private int id;

    /**
     * Empty Constructer.
     */
    public UserDto() {

    }

    /**
     * Full param constructer.
     * @param fName - firts name of user
     * @param lName - last name of user
     * @param iD - id of user
     */
    public UserDto(final String fName,
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

}
