package com.team7.app.controller;

import com.team7.app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Mapping for web pages to be called with
 * mustache templating.
 */
@Controller
public class WebPageController {

    /**
     * inject via application.properties.
     */
    @Value("${app.welcome.title}")
    private String title = "";

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private CourseServices courseService;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private ProfessorServices professorService;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private SectionServices sectionService;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private BuildingServices buildingService;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private RoomServices roomService;

    /**
     * Setter for ProfessorService, for testing purposes only.
     * @param courseServ - service to be used
     */
    public void setCourseService(final CourseServices courseServ) {
        this.courseService = courseServ;
    }

    /**
     * Setter for ProfessorService, for testing purposes only.
     * @param professorServ - service to be used
     */
    public void setProfessorService(final ProfessorServices professorServ) {
        this.professorService = professorServ;
    }

    /**
     * Setter for SectionService, for testing purposes only.
     * @param sectionServ - service to be used
     */
    public void setSectionService(final SectionServices sectionServ) {
        this.sectionService = sectionServ;
    }

    /**
     * Setter for BuildingService, for testing purposes only.
     * @param buildingServ - service to be used
     */
    public void setBuildingService(final BuildingServices buildingServ) {
        this.buildingService = buildingServ;
    }

    /**
     * Setter for RoomService, for testing purposes only.
     * @param roomServ - serivce to be used
     */
    public void setRoomService(final RoomServices roomServ) {
        this.roomService = roomServ;
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/create")
    public String create(final Map<String, Object> model) {
        model.put("title", title);
        return "create";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/courseCreate")
    public String courseCreate(final Map<String, Object> model) {
        model.put("title", title);
        return "courseCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/courseUpdate")
    public String courseUpdate(final Map<String, Object> model) {
        model.put("title", title);
        return "courseUpdate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/courseDelete")
    public String courseDelete(final Map<String, Object> model) {
        model.put("title", title);
        return "courseDelete";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/courseRead")
    public String courseRead(final Map<String, Object> model) {
        model.put("title", title);
        return "courseRead";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/delete")
    public String delete(final Map<String, Object> model) {
        model.put("title", title);
        return "delete";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/")
    public String index(final Map<String, Object> model) {
        model.put("title", title);
        return "index";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/professorCreate")
    public String professorCreate(final Map<String, Object> model) {
        model.put("title", title);
        return "professorCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/professorDelete")
    public String professorDelete(final Map<String, Object> model) {
        model.put("title", title);
        return "professorDelete";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/professorRead")
    public String professorRead(final Map<String, Object> model) {
        model.put("title", title);
        return "professorRead";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/professorUpdate")
    public String professorUpdate(final Map<String, Object> model) {
        model.put("title", title);
        return "professorUpdate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/read")
    public String read(final Map<String, Object> model) {
        model.put("title", title);
        return "read";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/update")
    public String update(final Map<String, Object> model) {
        model.put("title", title);
        return "update";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/sectionCreate")
    public String sectionCreate(final Map<String, Object> model) {
        model.put("title", title);
        model.put("courses", courseService.listAllCourse());
        model.put("professors", professorService.listAllProfessor());
        model.put("rooms", roomService.listAllRoom());
        return "sectionCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/sectionUpdate")
    public String sectionUpdate(final Map<String, Object> model) {
        model.put("title", title);
        model.put("courses", courseService.listAllCourse());
        model.put("professors", professorService.listAllProfessor());
        model.put("rooms", roomService.listAllRoom());
        model.put("sections", sectionService.listAllSection());
        return "sectionUpdate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/sectionRead")
    public String sectionRead(final Map<String, Object> model) {
        model.put("title", title);
        return "sectionRead";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/sectionDelete")
    public String sectionDelete(final Map<String, Object> model) {
        model.put("title", title);
        return "sectionDelete";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/buildingCreate")
    public String createBuilding(final Map<String, Object> model) {
        model.put("title", title);
        return "buildingCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/buildingRead")
    public String readBuilding(final Map<String, Object> model) {
        model.put("title", title);
        return "buildingRead";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/buildingUpdate")
    public String updateBuilding(final Map<String, Object> model) {
        model.put("title", title);
        model.put("buildings", buildingService.listAllBuilding());
        return "buildingUpdate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/buildingDelete")
    public String deleteBuilding(final Map<String, Object> model) {
        model.put("title", title);
        model.put("building_name", buildingService.listAllBuilding());
        return "buildingDelete";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/roomCreate")
    public String createRoom(final Map<String, Object> model) {
        model.put("title", title);
        model.put("buildings", buildingService.listAllBuilding());
        return "roomCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attribute to be injected to page.
     * @return String of the page name
     */
    @RequestMapping("/roomDelete")
    public String deleteRoom(final Map<String, Object> model) {
        model.put("title", title);
        return "roomDelete";
    }

    /**
     * Mapping for a web page.
     * @param model - attribute to be injected to page.
     * @return String of the page name
     */
    @RequestMapping("/roomUpdate")
    public String updateRoom(final Map<String, Object> model) {
        model.put("title", title);
        model.put("buildings", buildingService.listAllBuilding());
        return "roomUpdate";
    }

    /**
     * Mapping for a web page.
     * @param model - attribute to be injected to page.
     * @return String of the page name
     */
    @RequestMapping("/roomRead")
    public String readRoom(final Map<String, Object> model) {
        model.put("title", title);
        return "roomRead";
    }

}
