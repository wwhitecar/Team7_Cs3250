package team7.app.controller;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.team7.app.business.GlobalRowMapper;
import com.team7.app.business.dto.GlobalDto;
import com.team7.app.controller.GlobalController;

@RunWith(MockitoJUnitRunner.class)
public class GlobalControllerTest {

    @Mock
    private NamedParameterJdbcTemplate mockTemplate;
    GlobalController globalController = new GlobalController();

    @Before
    public void before() { globalController.namedJdbcTemplate = mockTemplate;}


    @Test
    public void createGlobalTest() {
        assertTrue(globalController.createGlobal("Metropolitan State University", 15).equals("Success"));
    }

    @Test
    public void updateGlobalTest() {
        assertTrue(globalController.updateGlobalByName("Metropolitan State University", 15).equals("Unable to update"));
        when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(globalController.updateGlobalByName("Harvard", 40), "Successfully Updated");
    }

    @Test
    public void deleteGlobalTest() {
        assertTrue(globalController.deleteGlobalByName("Metropolitan State University")
                .equals("Unable to find school to remove"));

        when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(globalController.deleteGlobalByName("Metropolitan State University"), "Successfully Removed");

    }

    @Test
    public void readGlobalTest() {
        assertTrue(globalController.readGlobalByName("Metropolitan State University")
                .equals("School not found, please try again"));
        GlobalDto global = new GlobalDto("Metropolitan State University", 15);
        List<GlobalDto> result = new ArrayList<>();
        result.add(global);
        when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class),
                any(GlobalRowMapper.class))).thenReturn(result);

        assertEquals(globalController.readGlobalByName("Metropolitan State University"), global.toString());

    }
}