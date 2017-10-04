package com.team7.app.business;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.business.dto.SectionDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class is responsible for iterating through
 * the result set that comes from the db.
 */
public class SectionRowMapper implements RowMapper<SectionDto> {

    /**
     * Empty Constructor.
     */
    public SectionRowMapper() {

    }

    /**
     * This is responsible for iterating through result set.
     * @param rs - A result set
     * @param rowNum - the row number
     * @return SectionDto - that is associated with that mapping
     * @throws SQLException
     */
    public SectionDto mapRow(final ResultSet rs,
                             final int rowNum) throws SQLException {
        SectionDto section = new SectionDto(rs.getInt("section_number"),
                rs.getInt("course_number"),
                rs.getString("professor"));
        return section;
    }
}