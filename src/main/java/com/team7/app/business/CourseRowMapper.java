package com.team7.app.business;

import com.team7.app.business.dto.CourseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class is responsible for iterating through
 * the result set that comes from th db.
 */
public class CourseRowMapper implements RowMapper<CourseDto> {

    /**
     * Empty Constructor.
     */
    public CourseRowMapper() {

    }

    /**
     * This is responsible for iterating through result set.
     * @param rs - A result set
     * @param rowNumber - the row number
     * @return Coursedto - that is associated with that mapping
     * @throws SQLException
     */
    @Override
    public CourseDto mapRow(final ResultSet rs,
                            final int rowNumber) throws SQLException {
        CourseDto course = new CourseDto(rs.getString("descripion"), rs.getInt("course_number"), rs.getInt("credits"), rs.getString("description"), rs.getString("learning_objective"), rs.getString("prereqs"), rs.getObject("coreqs"));
        return course;
    }
}
