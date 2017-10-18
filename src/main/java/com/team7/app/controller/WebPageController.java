package com.team7.app.controller;

import com.team7.app.services.CourseServices;
import com.team7.app.services.ProfessorServices;
import com.team7.app.services.SectionServices;
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
    protected CourseServices courseServices;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    protected ProfessorServices professorServices;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    protected SectionServices sectionServices;

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
    @RequestMapping("/section")
    public String sectionCreate(final Map<String, Object> model) {
        model.put("title", title);
        model.put("courses", courseServices.listAllCourse());
        model.put("professors", professorServices.listAllProfessor());
        return "sectionCreate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/section/update")
    public String sectionUpdate(final Map<String, Object> model) {
        model.put("title", title);
        model.put("courses", courseServices.listAllCourse());
        model.put("professors", professorServices.listAllProfessor());
        model.put("sections", sectionServices.listAllSection());
        return "sectionUpdate";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/section/sectionRead")
    public String sectionRead(final Map<String, Object> model) {
        model.put("title", title);
        return "sectionRead";
    }

    /**
     * Mapping for a web page.
     * @param model - attributes to be injected to page.
     * @return String of the page name.
     */
    @RequestMapping("/section/sectionDelete")
    public String sectionDelete(final Map<String, Object> model) {
        model.put("title", title);
        return "sectionDelete";
    }
}
