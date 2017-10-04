package com.team7.app.business;

import org.springframework.jdbc.core.RowMapper;
import com.team7.app.business.dto.GlobalDto;

import java.sql.ResultSet;
import java.sql.SQLException;



public class GlobalRowMapper implements RowMapper<GlobalDto> {

    public GlobalRowMapper() {

    }

    @Override
    public GlobalDto mapRow(final ResultSet  rs, final int rowNumber) throws SQLException {
        GlobalDto global  = new GlobalDto(rs.getString("school_name"), rs.getInt("credit_Hour"));
        return global;
    }
}
