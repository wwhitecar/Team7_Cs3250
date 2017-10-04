package com.team7.app.business;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.business.dto.ProfessorDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorRowMapper implements RowMapper<ProfessorDto> {

    /**
     * Empty Constructer.
     */
    public ProfessorRowMapper() {
    }

    /**
     * This is responsible for iterating through result set.
     * @param rs - A result set
     * @param rowNum - the row number
     * @return ProfessorDto - Professor
     * @throws SQLException
     */
    @Override
    public ProfessorDto mapRow(final ResultSet rs,
                               final int rowNum) throws SQLException {
        ProfessorDto dto = new ProfessorDto(rs.getString("first_name"), rs.getString("last_name"), rs.getInt("professor_id"));
        return dto;
    }
}