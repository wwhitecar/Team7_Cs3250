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
    @ManyToOne
    private CourseDto course;

    /**
     * The professor?
     */
    @ManyToOne
    private ProfessorDto professor;

    /**
     * Empty Constructer.
     */
    public SectionDto() {

    }

    /**
     * Param constructer.
     * @param course - course to be tied to this section
     * @param professor - professor of the class/section
     */
    public SectionDto( final int sectionNumber,
                       final CourseDto course,
                       final ProfessorDto professor) {
        this.sectionNumber = sectionNumber;
        this.course = course;
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
    public CourseDto getCourseNumber() {
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
    public String toString(){
        return "Course: </br>" + course.toString() + "</br>Professor: </br>" + professor.toString();
    }
}