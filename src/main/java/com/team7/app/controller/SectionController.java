package com.team7.app.controller;

import com.team7.app.business.dto.SectionDto;
import com.team7.app.business.dto.CourseDto;
import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.business.dto.RoomDto;
import com.team7.app.business.dto.SemesterDto;

import com.team7.app.services.CourseServices;
import com.team7.app.services.ProfessorServices;
import com.team7.app.services.RoomServices;
import com.team7.app.services.SectionServices;
import com.team7.app.services.SemesterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that will talk to the section webpages and the
 * databaes to assure proper transfer of data.
 */
@RestController
@RequestMapping(value = "/section")
public class SectionController {

    /**
     * Services to be used by hibernate to correctly add/remove
     * information to the database.
     */
    @Autowired
    private SectionServices sectionService;

    /**
     * Services to be used by hibernate to correctly add/remove
     * information to the database.
     */
    @Autowired
    private CourseServices courseService;

    /**
     * Services to be used by hibernate to correctly add/remove
     * information to the database.
     */
    @Autowired
    private ProfessorServices professorService;

    /**
     * Services to be used by hibernate to correctly add/remove
     * information to the database.
     */
    @Autowired
    private RoomServices roomService;

    /**
     * Services to be used by hibernate to correctly add/remove
     * information to the database.
     */
    @Autowired
    private SemesterServices semesterService;

    /**
     * Setter for ProfessorService, for testing purposes only.
     * @param semServ - service to be used
     */
    public void setSemesterService(final SemesterServices semServ) {
        this.semesterService = semServ;
    }

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
     * Setter for RoomService, for testing purposes only.
     * @param roomServ - room to be used
     */
    public void setRoomService(final RoomServices roomServ) {
        this.roomService = roomServ;
    }

    /**
     * Setter for SectionService, for testing purposes only.
     * @param sectionServ - service to be used
     */
    public void setSectionService(final SectionServices sectionServ) {
        this.sectionService = sectionServ;
    }

    /**
     * Will pull information from the webpages to create a
     * new class to be store into the database.
     * @param sectionNumber - id for the section
     * @param courseNumber - course specific number
     * @param professorName - professor teaching the section
     * @param roomNumber - room course will be taught in
     * @param semesterName - name of the semester the section is ot be added
     * @param day - day for this section
     * @param time - time for the section
     * @return state of the create request
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createSection(
            final @RequestParam ("section_number") int sectionNumber,
            final @RequestParam("course") int courseNumber,

            final @RequestParam("professor") String professorName,
            final @RequestParam ("room_number") int roomNumber,
            final @RequestParam ("Day") String day,
            final @RequestParam ("Time") String time,
            final @RequestParam("Semester") String semesterName) {
        RoomDto room = roomService.getRoomByNumber(roomNumber);
        CourseDto course = courseService.getCourseById(courseNumber);
        ProfessorDto professor = null;
        for (ProfessorDto prof: professorService.listAllProfessor()) {
            if (professorName.equals(prof.getFirstName()
                    + " " + prof.getLastName())) {
                professor = professorService.getProfessorById(prof.getId());
            }
        }
        SemesterDto semester = getSemester(semesterName);
        if (semester == null) {
            return "Cannot find semester, many errors, handle it";
        }

        if (checkConflict(room, professor, day, time)) {
            return "Conflict, please go back and try again";
        }
        SectionDto section = new SectionDto(sectionNumber,
                course, professor, room, day, Integer.parseInt(time));
        section = sectionService.saveSection(section);

        semester.getSections().add(section);
        return (section.toString() + " Added Successfully <br/> <a href="
                    + "/" + ">Go Back to main screen</a>");
    }

    /**
     * Will retrive the correct semester that the user wants to
     * check a conflict for.
     * @param semesterName - name of the semester we are looking for
     * @return the semester we want; null otherwise
     */
    private SemesterDto getSemester(final String semesterName) {
        for (SemesterDto semester : semesterService.listAllSemesters()) {
            if (semester.getSemesterName().equals(semesterName)) {
                return semester;
            }
        }
        return null;
    }

    /**
     * When trying to create a section we must make sure their are no conflicts
     * in the room with times. This is the method that will do that check.
     * @param room - the room that we are trying to create a section for
     * @param professor - the professor of the course we are creating
     * @param dayName - name of the day that will be checking for a conflict
     * @param time - the time we are chekcing for a conflict at.
     * @return true if there is a conflict; otherwise false.
     */
    private boolean checkConflict(final RoomDto room,
                                  final ProfessorDto professor,
                     final String dayName, final String time) {
        for (SectionDto section : sectionService.listAllSection()) {
            if (section.getRoom().getBuildingByName()
                    .equals(room.getBuildingByName())
                    && section.getRoom()
                    .getRoomNumber() == room.getRoomNumber()) {
                if (section.getDay().equals(dayName)) {
                    if (section.getTime() == Integer.parseInt(time)) {
                        return true;
                    }
                }
            }
        }
        for (SectionDto section : sectionService.listAllSection()) {
            if (section.getProfessor().getId() == professor.getId()) {
                if (section.getDay().equals(dayName)) {
                    if (section.getTime() == Integer.parseInt(time)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Will pull information from the webpages to update a
     * section to be store into the database.
     * @param sectionNumber - the number for the course
     * @param courseNumber - course specific number
     * @param professorName - professor teaching the section
     * @param roomNumber - room course will be taught in
     * @param day - day for the section.
     * @param time - the time for the section
     * @return state of the create request
     */
    @RequestMapping(value = "/updatesection", method = RequestMethod.POST)
    public String updateSection(
            final @RequestParam ("section_number") int sectionNumber,
            final @RequestParam("course") int courseNumber,
            final @RequestParam("professor") String professorName,
            final @RequestParam ("room_number") int roomNumber,
            final @RequestParam ("Day") String day,
            final @RequestParam ("Time") String time) {
        CourseDto course = courseService.getCourseById(courseNumber);
        ProfessorDto professor = null;
        for (ProfessorDto prof: professorService.listAllProfessor()) {
            if (professorName.equals(prof.getLastName()
                    + " " + prof.getLastName())) {
                professor = professorService.getProfessorById(prof.getId());
            }
        }
        RoomDto room = roomService.getRoomByNumber(roomNumber);
        SectionDto section
                = new SectionDto(sectionNumber,
                course, professor, room, day, Integer.parseInt(time));
        section = sectionService.saveSection(section);
        return (section.toString()
               + " Updated Section Successfully <br/> <a href="
               + "/" + ">Go Back to main screen</a>");
    }


    /**
     * Will quarry the data base to pull the specific section
     * by the Section Number.
     * @param sectionNumber - course number that we will search for in the db
     * @return the information for the provided course
     */
    @RequestMapping(value = "/getsection", method = RequestMethod.GET)
    public String readSectionByNumber(
            final @RequestParam("section_number") int sectionNumber) {
        SectionDto  section = sectionService.getSectionById(sectionNumber);
        return (section.toString() + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>");
    }

    /**
     * Will attempt to remove a section from the database that corresponds
     * to section number provided to the webpage.
     * @param sectionNumber - number of the course we would like to delete
     * @return status of the delete request
     */
    @RequestMapping (value = "/deleteSection", method = RequestMethod.GET)
    public String deleteCourseByNumber(
            final @RequestParam("section_number") int sectionNumber) {
        sectionService.deleteSection(sectionNumber);
        return ("Removed Section"
                + "<br/> <a href=" + "/"
                + ">Go Back to main screen</a>");

    }
}
