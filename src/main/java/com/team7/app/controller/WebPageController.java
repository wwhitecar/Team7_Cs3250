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
    private SemesterServices semesterService;

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
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private ScheduleServices scheduleService;
  
    @Autowired
    private DayServices dayService;

    /**
     * Setter for ProfessorService, for testing purposes only.
     * @param courseServ - service to be used
     */
    public void setCourseService(final CourseServices courseServ) {
        this.courseService = courseServ;
    }

    /**
     * Setter for SemesterService, for testing purposes only.
     * @param semServ - service to be used
     */
    public void setSemesterService(final SemesterServices semServ) {
        this.semesterService = semServ;
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
     * Setter for ScheduleService, for testing purposes only.
     * @param scheduleServ - serivce to be used
     */
    public void setScheduleService(final ScheduleServices scheduleServ) {
        this.scheduleService = scheduleServ;
    }
     /**
     * Setter for RoomService, for testing purposes only.
     * @param dayServ - serivce to be used
     */
    public void setDayService(final DayServices dayServ) {
        this.dayService = dayServ;
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
        model.put("semesters", semesterService.listAllSemesters());
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
      
    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/scheduleCreate")
    public String createSchedule(final Map<String, Object> model) {
        model.put("title", title);
        model.put("sections", sectionService.listAllSection());
        return "scheduleCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/scheduleRead")
    public String readSchedule(final Map<String, Object> model) {
        model.put("title", title);
        return "buildingRead";
    }
      
    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */

    @RequestMapping("/scheduleUpdate")
    public String updateSchedule(final Map<String, Object> model) {
        model.put("title", title);
        model.put("schedules", scheduleService.listAllSchedule());
        return "scheduleUpdate";
    }
    @RequestMapping("/dayCreate")
    public String createDay(final Map<String, Object> model) {
        model.put("title", title);
        model.put("days", dayService.listAllDays());
        return "dayCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/scheduleDelete")
    public String deleteSchedule(final Map<String, Object> model) {
        model.put("title", title);
        model.put("schedule_name", scheduleService.listAllSchedule());
        return "scheduleDelete";
    }/**
     * @param model - attribute to be injected to page.
     * @return String of the page name
     */
    @RequestMapping("/dayRead")
    public String readDay(final Map<String, Object> model) {
        model.put("title", title);
        return "dayRead";
    }

    /**
     * Mapping for a web page.
     * @param model - attribute to be injected to page.
     * @return String of the page name
     */
    @RequestMapping("/semesterRead")
    public String readSemester(final Map<String, Object> model) {
        model.put("title", title);
        return "semesterRead";
     }
      
    @RequestMapping("/dayUpdate")
    public String updateDay(final Map<String, Object> model) {
        model.put("title", title);
        model.put("days", dayService.listAllDays());
        return "dayUpdate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/semesterDelete")
    public String deleteSemester(final Map<String, Object> model) {
        model.put("title", title);
        model.put("semesters", semesterService.listAllSemesters());
        return "semesterDelete";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/semesterCreate")
    public String createSemester(final Map<String, Object> model) {
        model.put("title", title);
        return "semesterCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/semesterUpdate")
    public String updateSemester(final Map<String, Object> model) {
        model.put("title", title);
        model.put("semesters", semesterService.listAllSemesters());
        return "semesterUpdate";
    }
    /**
     * @param model - attribute to be injected to page.
     * @return String of the page name
     */
    @RequestMapping("/dayDelete")
    public String deleteDay(final Map<String, Object> model) {
        model.put("title", title);
        return "dayDelete";
    }

}
