package com.team7.app.controller;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.business.dto.SectionDto;
import com.team7.app.services.CourseServices;
import com.team7.app.services.ProfessorServices;
import com.team7.app.services.SectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/section")
public class SectionController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    private SectionServices sectionServices;

    private CourseServices courseServices;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    private ProfessorServices professorServices;

    /**
     * Bean to be used throughout the professor class.
     * @param profService - bean to be created
     */
    @Autowired
    public void setProfessorService(final ProfessorServices profService) {
        this.professorServices = profService;
    }
    /**
     * Bean to be used throughout the course controller class.
     * @param cService - bean to be created
     */
    @Autowired
    public void setCourseService(final CourseServices cService) {
        this.courseServices = cService;
    }

    /**
     * Bean to be used throughout the course controller class.
     * @param sServices - bean to be created
     */
    @Autowired
    public void setSectionServices(final SectionServices sServices) {
        this.sectionServices = sServices;
    }
    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param courseNumber - course specific number
     * @param professorId - professor teaching the section
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createSection(
            final @RequestParam ("section_number") int sectionNumber,
            final @RequestParam("course") int courseNumber,
            final @RequestParam("professor") int professorId) {
        CourseDto course = courseServices.getCourseById(courseNumber);
        ProfessorDto professor = professorServices.getProfessorById(professorId);
        SectionDto section = new SectionDto(sectionNumber, course, professor);
        sectionServices.saveSection(section);
        return ("Success");
    }


    /**
     * Will quarry the data base to pull the specific section
     * by the Section Number.
     * @param sectionNumber - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/getsection", method = RequestMethod.GET)
    public String readSectionByNumber(
            final @RequestParam("course_number") int sectionNumber) {
        return "";
    }
}