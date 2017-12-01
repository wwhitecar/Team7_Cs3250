package com.team7.app.business.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Sections that will store professor and course
 * for classes.
 */
@Entity
public class SectionDto {

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @Id
    private int sectionNumber;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @ManyToOne(cascade = CascadeType.REMOVE)
    private CourseDto course;

    /**
     * The professor?
     */
    @ManyToOne(cascade = CascadeType.REMOVE)
    private ProfessorDto professor;

    /**
     * The room that is associated with this section.
     */
    @ManyToOne(cascade = CascadeType.REMOVE)
    private RoomDto room;

    /**
     * The time for this section.
     */
    private int time;

    /**
     * The day associated with this section.
     */
    private String day;

    /**
     * Empty Constructer.
     */
    public SectionDto() {

    }

    /**
     * Param constructer.
     * @param sNumber - identification for this section
     * @param courseDto - course to be tied to this section
     * @param professorDto - professor of the class/section
     * @param roomDto - room associated with this section.
     * @param dayName - name of the day for this section
     * @param classTime - time of the course
     */
    public SectionDto(final int sNumber,
                      final CourseDto courseDto,
                      final ProfessorDto professorDto,
                      final RoomDto roomDto,
                      final String dayName,
                      final int classTime) {
        this.sectionNumber = sNumber;
        this.course = courseDto;
        this.professor = professorDto;
        this.room = roomDto;
        this.time = classTime;
        this.day = dayName;
    }

    /**
     * Getter for coursenumber.
     * @return number for the course.
     */
    public int getSectionNumber() {
        return sectionNumber;
    }


    /**
     * Getter for coursenumber.
     * @return number for the course.
     */
    public CourseDto getCourse() {
        return course;
    }

    /**
     * Getter for the prof of the section.
     * @return the professor of the section.
     */
    public ProfessorDto getProfessor() {
        return professor;
    }

    /**
     * Overrides the tostring method.
     * @return the new string of information
     */
    @Override
    public String toString() {
        return "Course: </br>" + course.toString()
                + "</br>Professor: </br>" + professor.toString();
    }

    /**
     * Getter for the room of this section.
     * @return the room for this section.
     */
    public RoomDto getRoom() {
        return room;
    }

    /**
     * Getter for the time of this section.
     * @return the time for this course
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Getter for the day of this section.
     * @return the day for the section
     */
    public String getDay() {
        return this.day;
    }
}

