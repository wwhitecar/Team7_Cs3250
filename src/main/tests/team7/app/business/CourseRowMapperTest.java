package team7.app.business;

import com.team7.app.business.CourseRowMapper;
import org.junit.Test;
import java.sql.SQLException;

public class CourseRowMapperTest {

    @Test (expected = NullPointerException.class)
    public void mapRowTest() throws SQLException {
        CourseRowMapper courseRM = new CourseRowMapper();
        courseRM.mapRow(null, 0);
    }
}
