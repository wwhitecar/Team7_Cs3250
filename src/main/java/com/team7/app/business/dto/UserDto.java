package com.team7.app.business.dto;

public class UserDto {

	private String firstName;
	private String lastName;
	private int id;

    /**
     * Empty Constructer
     */
    public UserDto(){

    }

    public UserDto(String firstName, String lastName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    /**
     * get the first name of user
     * @return String - first name of user
     */
	public String getFirstName() {

		return firstName;
	}

    /**
     * Gets the last name of the user
     * @return String - Last name of the user
     */
	public String getLastName() {

		return lastName;
	}

    /**
     * Get id of the user
     * @return Int - the id for the user
     */
	public int getId() {

	    return id;
	}

}
