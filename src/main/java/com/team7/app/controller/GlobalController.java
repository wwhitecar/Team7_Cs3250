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

@RequestMapping(value = "/global")
@RestController
public class GlobalController {

    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate;

    @Value ("${sql.global.insertGlobalSql}")
    private String insertGlobalSql;

    @Value ("${sql.global.getGlobalByUniNameSql}")
    private String getGlobalByUniNameSql;

    @Value ("${sql.global.deleteGlobalByUniNameSql")
    private String deleteGlobalByUniNameSql;

    @Value ("${sql.global.updateGlobalByUniNameSql")
    private String updateGlobalByUniNameSql;



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

    @RequestMapping(value = "/school_name", method = RequestMethod.GET)
    public String readGlobalByName(final @RequestParam("School Name") String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("school_name", name);
        List<GlobalDto> dto = namedJdbcTemplate.query(getGlobalByUniNameSql, params,
                new GlobalRowMapper());
        GlobalDto global = dto.get(0);
        return ("Name: " + global.getSchoolName() + " " + global.getLevelByHour());

    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGlobalByName(final @RequestParam("School Name") String schoolName,
                                     final @RequestParam("credit_Hour") int creditHours) {
        Map<String, Object> params = new HashMap<>();
        params.put("school_name", schoolName);
        params.put("credit_Hour", creditHours);
        int rowsChanged = namedJdbcTemplate.update(updateGlobalByUniNameSql, params);
        if(rowsChanged < 1) {
            return ("Unable to update");
        }
        return "Update Successful";
    }

    @RequestMapping(value = "/name/", method = RequestMethod.GET)
    public String deleteGlobalByName(final @RequestParam("School Name") String schoolName) {
        Map<String, Object> params = new HashMap<>();
        params.put("school_name", schoolName);
        int rowsChanged = namedJdbcTemplate.update(deleteGlobalByUniNameSql, params);
        if (rowsChanged >=1) {
            return "successfully Removed";
        }
        return ("Unable to remove global");

    }

}
