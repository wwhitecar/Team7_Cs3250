package com.team7.app.controller;

import com.team7.app.business.dto.SectionDto;
import com.team7.app.business.SectionRowMapper;
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
@RequestMapping(value = "/sections")
public class SectionController {

    /**
     * Wires from the configuration class 'BaseConfig'.
     */
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate;

    /**
     * sql.insertSectionSql = insertSection
     * controlled via yml file.
     */
    @Value("${sql.section.insertSectionSql}")
    private String insertSectionSql;

    /**
     * sql.getSectionSql = getSection
     * controlled via yml file.
     */
    @Value("${sql.section.getSectionByNumber}")
    private String getSectionByNumber;

    /**
     * sql.deleteSectionSql = deleteSection
     * controlled via yml file.
     */
    @Value("${sql.section.deleteSectionByNumber}")
    private String deleteSectionByNumber;

    /**
     * sql.updateSectionSql = updateSection
     * controlled via yml file.
     */
    @Value("${sql.section.updateSectionByNumber}")
    private String updateSectionByNumber;

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param courseNumber - course specific number
     * @param professor - professor teaching the section
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createCourse(
            final @RequestParam("course_number") int courseNumber,
            final @RequestParam("professor") String professor) {

        Map<String, Object> params = new HashMap<>();
        params.put("course_number", courseNumber);
        params.put("professor", professor);

        int rowsChanged = namedJdbcTemplate.update(insertSectionSql, params);
        return ("Success");
    }


    /**
     * Will quary the data base to pull the specific course
     * by the Course Number.
     * @param courseNumber - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/getcourse", method = RequestMethod.GET)
    public String readSectionByNumber(
            final @RequestParam("course_number") int courseNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("course_number", courseNumber);
        List<SectionDto> dto = namedJdbcTemplate.query(getSectionByNumber,
                params, new SectionRowMapper());
        if (dto.size() == 0){
            return ("Course not found, please try again with another Course Number");
        }
        SectionDto section = dto.get(0);
        return ("Section Information: \r\n Section Number: " + section.getSectionNumber()
                + "\r\n Professor: " + section.getProfessor()
                + "\r\n Course Number: " + section.getCourseNumber());
    }
}