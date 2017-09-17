package com.team7.app.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.team7.app.business.dto.UserDto;

/**
 *  This will iterate through the result set
 *  that comes from the database.
 */
public class UserRowMapper implements RowMapper<UserDto> {

    /**
     * Empty Constructer.
     */
    public UserRowMapper() {
    }

    /**
    * This is responsible for iterating through result set.
    * @param rs - A result set
    * @param rowNum - the row number
    * @return Userdto - User
    * @throws SQLException
    */
    @Override
    public UserDto mapRow(final ResultSet rs,
            final int rowNum) throws SQLException {
        UserDto dto = new UserDto(rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("student_id"));
        return dto;
    }
}
