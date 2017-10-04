package team7.app.business;

import com.team7.app.business.UserRowMapper;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserRowMapperTest {

    @Test(expected = NullPointerException.class)
    public void mapRowTest() throws SQLException {
        UserRowMapper userRM = new UserRowMapper();
        userRM.mapRow(null, 0);
    }
}