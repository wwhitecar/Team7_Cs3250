package com.team7.app.business;

import org.springframework.jdbc.core.RowMapper;
import com.team7.app.business.dto.GlobalDto;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Class is responsible for iterating through
 * the result set that comes from th db.
 */
public class GlobalRowMapper implements RowMapper<GlobalDto> {

    /**
     * Empty Constructor.
     */
    public GlobalRowMapper() {

    }

    /**
     * This is responsible for iterating through result set.
     * @param rs - A result set
     * @param rowNumber - the row number
     * @return Coursedto - that is associated with that mapping
     * @throws SQLException
     */
    @Override
    public GlobalDto mapRow(final ResultSet  rs,
                            final int rowNumber) throws SQLException {
        GlobalDto global  = new GlobalDto(rs.getString("school_name"),
                rs.getInt("credit_Hour"));
        return global;
    }
}
