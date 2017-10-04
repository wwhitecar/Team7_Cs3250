package com.team7.app.controller;

import com.team7.app.business.ProfessorRowMapper;
import com.team7.app.business.dto.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {

    /**
     * Wires from the configuration class 'BaseConfig'.
     */
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * Basically sql.insertProfessorSql = insertProfessor
     * controlled via yml file.
     */
    @Value("${sql.sqlprofessor.insertProfessorSql}")
    private String insertProfessorSql;

    /**
     * Basically sql.getProfessorSql = getProfessor
     * controlled via yml file.
     */
    @Value("${sql.sqlprofessor.getProfessorByIdSql}")
    private String getProfessorByIdSql;

    /**
     * Basically sql.deleteProfessorSql = deleteProfessor
     * controlled via yml file.
     */
    @Value("${sql.sqlprofessor.deleteProfessorByIdSql}")
    private String deleteProfessorByIdSql;

    /**
     *Basically sql.updateProfessorSql = updateProfessor
     * controlled via yml file.
     */
    @Value("${sql.sqlprofessor.updateProfessorByIdSql}")
    private String updateProfessorByIdSql;

    /**
     * Creates a professor and puts it in the database.
     * @param id - id of the professor
     * @param firstName - first name of the professor
     * @param lastName - last name of professor
     * @return String - message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createProfessor(final @RequestParam("Id")int id,
                                  final @RequestParam("First Name")String firstName,
                                  final @RequestParam("Last Name")String lastName) {
        Map<String, Object> params = new HashMap<>();
        params.put("professor_id", id);
        params.put("first_name", firstName);
        params.put("last_name", lastName);
        namedJdbcTemplate.update(insertProfessorSql, params);
        return "Success";
    }

     /**
     * Read a Professor from the database.
     * @param id - Value to search for Professor with
     * @return String with Professor infromation
      */
    @RequestMapping(value = "/getprofessor/", method = RequestMethod.GET)
    public String readProfessorById(final @RequestParam("Id") int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("professor_id", id);
        List<ProfessorDto> dto = namedJdbcTemplate.query(getProfessorByIdSql,
                params, new ProfessorRowMapper());
        ProfessorDto professor = dto.get(0);
        return ("Name: " + professor.getFirstName() + " " + professor.getLastName()
                + "\nProfessor Id: " + professor.getId());
    }

    /**
     * Update a professor already in the database.
     * @param id - id of the professor to be found
     * @param firstName - new first name of the professor
     * @param lastName - new last name of the professor
     * @return String to be displayed to professor after trying to update
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateProfessorById(final @RequestParam("Id")int id,
                                      final @RequestParam("First Name")String firstName,
                                      final @RequestParam("Last Name")String lastName) {
        Map<String, Object> params = new HashMap<>();
        params.put("professor_id", id);
        params.put("first_name", firstName);
        params.put("last_name", lastName);
        int rowsChanged = namedJdbcTemplate.update(updateProfessorByIdSql, params);
        if (rowsChanged < 1) {
            return ("Unable to find professor to update, try again with different id.");
        }
        return "Successfully Updated";
    }

    /**
     * Delete a professor that is in the database.
     * @param id - id of the professor to be deleted
     * @return String to be displayed to professor after deleteing them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteProfessorById(final @RequestParam("Id") int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("professor_id", id);
        int rowsChanged = namedJdbcTemplate.update(deleteProfessorByIdSql, params);
        if (rowsChanged >= 1){
            return "Successfully Removed";
        }
        return ("Unable to remove professor, try again with different id");
    }
}