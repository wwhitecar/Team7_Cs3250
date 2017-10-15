package com.team7.app.controller;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.business.dto.BuildingDto;
import com.team7.app.services.CourseServices;
import com.team7.app.services.ProfessorServices;
import com.team7.app.services.BuildingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/building")
public class BuildingController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    private BuildingServices buildingServices;

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
    public void setBuildingServices(final BuildingServices sServices) {
        this.buildingServices = sServices;
    }
    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param courseNumber - course specific number
     * @param professorId - professor teaching the building
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createBuilding(
            final @RequestParam ("building_number") int buildingNumber,
            final @RequestParam("course") int courseNumber,
            final @RequestParam("professor") int professorId) {
        CourseDto course = courseServices.getCourseById(courseNumber);
        ProfessorDto professor = professorServices.getProfessorById(professorId);
        BuildingDto building = new BuildingDto(buildingNumber, course, professor);
        BuildingServices.saveBuilding(building);
        return ("Success");
    }


    /**
     * Will quarry the data base to pull the specific building
     * by the Building Number.
     * @param buildingNumber - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/getbuilding", method = RequestMethod.GET)
    public String readBuildingByNumber(
            final @RequestParam("course_number") int buildingNumber) {
        return "";
    }
}