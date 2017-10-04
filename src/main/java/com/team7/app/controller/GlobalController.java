package com.team7.app.controller;



import com.team7.app.business.dto.GlobalDto;
import com.team7.app.business.GlobalRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global class controller to talk to the database.
 */
@RequestMapping(value = "/global")
@RestController
public class GlobalController {

    /**
     * Wires from the configuration class 'BaseConfig'.
     */
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * Basically sql.insertGlobalSql = insertGlobal
     * controlled via yml file.
     */
    @Value ("${sql.global.insertGlobalSql}")
    private String insertGlobalSql;

    /**
     * Basically sql.getGlobalSql = getGlobal
     * controlled via yml file.
     */
    @Value ("${sql.global.getGlobalByUniNameSql}")
    private String getGlobalByUniNameSql;

    /**
     * Basically sql.deleteGlobalSql = deleteGlobal
     * controlled via yml file.
     */
    @Value ("${sql.global.deleteGlobalByUniNameSql")
    private String deleteGlobalByUniNameSql;

    /**
     *Basically sql.updateUserSql = updateUser
     * controlled via yml file.
     */
    @Value ("${sql.global.updateGlobalByUniNameSql")
    private String updateGlobalByUniNameSql;

    /**
     * Mapping to create a new global value in database.
     * @param schoolName - name of the school
     * @param creditHours - credit hours.
     * @return status of the request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public  String createGlobal(
            final @RequestParam("school_name") String schoolName,
            final @RequestParam("credit_Hour") int creditHours)  { //change var

        Map<String, Object> params = new HashMap<>();
        params.put("school_name", schoolName);
        params.put("credit_Hour", creditHours);
        namedJdbcTemplate.update(insertGlobalSql, params);
        return "Success";

    }

    /**
     * Reads the global values and displays them from the database.
     * @param name - school name to get the information for.
     * @return information about the school.
     */
    @RequestMapping(value = "/school_name", method = RequestMethod.GET)
    public String readGlobalByName(
            final @RequestParam("School Name") String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("school_name", name);
        List<GlobalDto> dto = namedJdbcTemplate.query(
                getGlobalByUniNameSql, params,
                new GlobalRowMapper());
        GlobalDto global = dto.get(0);
        return ("Name: " + global.getSchoolName() + " "
                + global.getLevelByHour());

    }

    /**
     * Mapping for update to change the global values in database.
     * @param schoolName - new name of the school.
     * @param creditHours - new credits hours for school
     * @return status of the request
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGlobalByName(
            final @RequestParam("School Name") String schoolName,
            final @RequestParam("credit_Hour") int creditHours) {
        Map<String, Object> params = new HashMap<>();
        params.put("school_name", schoolName);
        params.put("credit_Hour", creditHours);
        int rowsChanged = namedJdbcTemplate.update(updateGlobalByUniNameSql,
                params);
        if (rowsChanged < 1) {
            return ("Unable to update");
        }
        return "Update Successful";
    }

    /**
     * Mapping to delete the global for the database.
     * @param schoolName - name of the school
     * @return status of the request
     */
    @RequestMapping(value = "/name/", method = RequestMethod.GET)
    public String deleteGlobalByName(
            final @RequestParam("School Name") String schoolName) {
        Map<String, Object> params = new HashMap<>();
        params.put("school_name", schoolName);
        int rowsChanged = namedJdbcTemplate.update(deleteGlobalByUniNameSql,
                params);
        if (rowsChanged >= 1) {
            return "successfully Removed";
        }
        return ("Unable to remove global");

    }

}
