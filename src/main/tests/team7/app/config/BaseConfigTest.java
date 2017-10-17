package team7.app.config;

import com.team7.app.config.BaseConfig;
import org.junit.Test;

import javax.sql.DataSource;

import static org.junit.Assert.assertTrue;

public class BaseConfigTest {

    @Test
    public void scheduleDataSourceTest(){
        BaseConfig bC = new BaseConfig();
        assertTrue(bC.scheduleDataSource() != null);
    }

    @Test
    public void namedJdbcTemplateTest(){
        BaseConfig bC = new BaseConfig();
        DataSource dS = bC.scheduleDataSource();
        assertTrue(dS != null);
    }
}