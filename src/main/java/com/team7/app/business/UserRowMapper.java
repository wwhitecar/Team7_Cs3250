package com.team7.app.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.team7.app.business.dto.UserDto;

public class UserRowMapper implements RowMapper<UserDto> { // this will iterate through the result set that comes from the database.

	public UserRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException { //this is responsible for iterating through result set (each row returned from the query)
		UserDto dto = new UserDto();
		dto.setId(rs.getInt("student_id"));//the string values need to match the name of the database column
		dto.setFirstName(rs.getString("first_name"));//the string values need to match the name of the database column
		dto.setLastName(rs.getString("last_name"));//the string values need to match the name of the database column
		return dto;
	}

}
