package team7.app;

import com.team7.Application;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test(expected = IllegalArgumentException.class)
    public void emptyApplicationContext() throws Exception {
        Application app = new Application();
        app.main(null);

    }
}