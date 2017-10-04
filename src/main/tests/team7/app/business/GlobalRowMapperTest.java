package team7.app.business;


import com.team7.app.business.GlobalRowMapper;
import org.junit.Test;
import java.sql.SQLException;

public class GlobalRowMapperTest {

    @Test (expected = NullPointerException.class)
    public void mapRowTest() throws SQLException {
        GlobalRowMapper globalRM = new GlobalRowMapper();
        globalRM.mapRow(null, 0);
    }
}