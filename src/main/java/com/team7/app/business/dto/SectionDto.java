package com.team7.app.business.dto;

import javax.persistence.*;

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
    @OneToMany
    private int courseNumber;

    /**
     * The professor?
     */
    @OneToMany
    private String professor;

    /**
     * Param constructer.
     * @param courseNumber -coursenumber
     * @param professor - professor of the class/section
     */
    public SectionDto(final int sectionNumber,
                      final int courseNumber,
                      final String professor) {
        this.sectionNumber = sectionNumber;
        this.courseNumber = courseNumber;
        this.professor = professor;
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
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Getter for the prof of the section.
     * @return the professor of the section.
     */
    public String getProfessor() {
        return professor;
    }

}