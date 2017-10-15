package team7.app.controller;

import com.team7.app.controller.ProfessorController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyMapOf;
import static org.mockito.Mockito.any;
import com.team7.app.business.dto.ProfessorDto;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorControllerTest {

    @Mock
    private NamedParameterJdbcTemplate mockTemplate;
    ProfessorController professorController = new ProfessorController();
    ProfessorDto professor = new ProfessorDto("Alex","Whitlatch", 33);

    @Before
    public void before(){

    }

    @Test
    public void createProfessor() throws Exception {
        assertEquals(professorController.createProfessor(33, "Alex", "Whitlatch"), "Success");
    }

    @Test
    public void readProfessorById() throws Exception {
        List<ProfessorDto> result = new ArrayList<>();
        result.add(professor);
 //       when(mockTemplate.query(anyString(), anyMapOf(String.class, Object.class), any(ProfessorRowMapper.class))).thenReturn(result);
        assertEquals(professorController.readProfessorById(33), "");

    }

    @Test
    public void updateProfessorById() throws Exception {
        assertEquals(professorController.updateProfessorById(33, "Alex", "Whitlatch"),
                "Unable to find professor to update, try again with different id.");
        when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(professorController.updateProfessorById(33, "Trevor", "Whitecar"), "Successfully Updated");

    }

    @Test
    public void deleteProfessorById() throws Exception {
        assertEquals(professorController.deleteProfessorById(33),
                "Unable to remove professor, try again with different id");
        when(mockTemplate.update(anyString(), anyMapOf(String.class, Object.class))).thenReturn(1);
        assertEquals(professorController.deleteProfessorById(33), "Successfully Removed");
    }
}